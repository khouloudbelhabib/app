package com.khouloud.auditapp.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reclamation {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn( name="id" )
    private User user;
    private String probleme;

    public Reclamation(Long id , User user, String probleme) {
        this.id = id;
        this.user = user;
        this.probleme = probleme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProbleme() {
        return probleme;
    }

    public void setProbleme(String probleme) {
        this.probleme = probleme;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

