package com.khouloud.auditapp.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rapport {
    @Id
    @GeneratedValue
    private long id;
    private List<Risque> RisqueList;
    @OneToOne(mappedBy = "rapport")
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Risque> getRisqueList() {
        return RisqueList;
    }

    public void setRisqueList(List<Risque> risqueList) {
        RisqueList = risqueList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
