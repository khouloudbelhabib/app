package com.khouloud.auditapp.Entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;


@Entity
public class RendezVous implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @CreatedDate
    @Column(name = "CREATION_TS", nullable = false, updatable = false)
    private Date createTime;

    @NotNull
    @LastModifiedDate
    @Column(name = "MODIFIED_TS", nullable = false)
    private Date modifiedTime;

    private String lieu;
    private Date  date ;
    private Time heurededebut;
    private Time heuredefin;
    @ManyToOne
    private User user;

    public RendezVous() {
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


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
