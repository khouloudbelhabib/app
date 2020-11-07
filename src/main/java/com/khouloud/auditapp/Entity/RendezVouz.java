package com.khouloud.auditapp.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RendezVouz {
    @Id
    @GeneratedValue
    private Long id;
    private String lieu;
    private String jour;
    private Time heurededebut;
    private Time heuredefin;
    @ManyToOne
    private User user;

    public Time getHeurededebut() {
        return heurededebut;
    }

    public void setHeurededebut(Time heurededebut) {
        this.heurededebut = heurededebut;
    }

    public Time getHeuredefin() {
        return heuredefin;
    }

    public void setHeuredefin(Time heuredefin) {
        this.heuredefin = heuredefin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
