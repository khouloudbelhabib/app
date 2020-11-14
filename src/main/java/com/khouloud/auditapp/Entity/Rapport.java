package com.khouloud.auditapp.Entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
public class Rapport implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @CreatedDate
    @Column(name = "CREATION_TS", nullable = false, updatable = false)
    private Date createTime;

    @NotNull
    @LastModifiedDate
    @Column(name = "MODIFIED_TS", nullable = false)
    private Date modifiedTime;

    @ManyToMany
    private List<Risque> risqueList;

    @ManyToOne
    User user;

    public Rapport() {
    }

    public Rapport(List<Risque> risqueList) {
        this.risqueList = risqueList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<Risque> getRisqueList() {
        return risqueList;
    }

    public void setRisqueList(List<Risque> risqueList) {
        this.risqueList = risqueList;
    }

}
