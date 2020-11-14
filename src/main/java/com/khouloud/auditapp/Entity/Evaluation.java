package com.khouloud.auditapp.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@AllArgsConstructor
@Data

@NoArgsConstructor
@Entity
public class Evaluation {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private User user;
    private String Username;
    private String commentaire;
    private int niveaudesatesfaction;

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNiveaudesatesfaction() {
        return niveaudesatesfaction;
    }

    public void setNiveaudesatesfaction(int niveaudesatesfaction) {
        this.niveaudesatesfaction = niveaudesatesfaction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
