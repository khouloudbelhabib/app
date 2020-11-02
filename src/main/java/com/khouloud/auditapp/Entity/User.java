package com.khouloud.auditapp.Entity;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    private String secteur;
    private int nombreanee;
    private boolean enabled;
    private String logo;
    private String password;
    @OneToOne
    @JoinColumn(name = "id")
    private Evaluation evaluation;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> role;
    @OneToMany(mappedBy = "user")
    private List<Reclamation> reclamationlist;
    @OneToMany (mappedBy = "user")
    private  List<rendezvouz> rendezvouzlist;
    @OneToOne
    @JoinColumn(name = "id")
    private Rapport rapport;

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonSetter
    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getNombreanee() {
        return nombreanee;
    }

    public void setNombreanee(int nombreanee) {
        this.nombreanee = nombreanee;
    }

    public Collection<Role> getRole() {
        return role;
    }

    public void setRole(Collection<Role> role) {
        this.role = role;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    public List<Reclamation> getReclamationlist() {
        return reclamationlist;
    }

    public void setReclamationlist(List<Reclamation> reclamationlist) {
        this.reclamationlist = reclamationlist;
    }

    public List<rendezvouz> getRendezvouzlist() {
        return rendezvouzlist;
    }

    public void setRendezvouzlist(List<rendezvouz> rendezvouzlist) {
        this.rendezvouzlist = rendezvouzlist;
    }

    public Rapport getRapport() {
        return rapport;
    }

    public void setRapport(Rapport rapport) {
        this.rapport = rapport;
    }
}
