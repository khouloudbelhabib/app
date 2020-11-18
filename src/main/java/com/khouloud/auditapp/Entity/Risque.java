package com.khouloud.auditapp.Entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
public class Risque implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;


    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedTime;

    private String Nom;
    private Boolean selected;
    private String niveau;
    private String impact;
    private String solution;
    @ManyToMany
    List<Rapport>rapports;

    public Risque() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
       return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public List<Rapport> getRapports() {
        return rapports;
    }

    public void setRapports(List<Rapport> rapports) {
        this.rapports = rapports;
    }

    @Override
    public String toString() {
        return "Risque{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", modifiedTime=" + modifiedTime +
                ", Nom='" + Nom + '\'' +
                ", selected=" + selected +
                ", niveau='" + niveau + '\'' +
                ", impact='" + impact + '\'' +
                ", solution='" + solution + '\'' +
                ", rapports=" + rapports +
                '}';
    }
}
