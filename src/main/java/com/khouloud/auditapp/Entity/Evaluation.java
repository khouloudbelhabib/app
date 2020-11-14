package com.khouloud.auditapp.Entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Entity
public class Evaluation implements Serializable {
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

    private String commentaire;

    private int niveaudesatesfaction;

    @ManyToOne
    private User user;

    public Evaluation() {
    }

    public Evaluation(User user, String commentaire, int niveaudesatesfaction) {
        this.user = user;
        this.commentaire = commentaire;
        this.niveaudesatesfaction = niveaudesatesfaction;
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

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
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


}
