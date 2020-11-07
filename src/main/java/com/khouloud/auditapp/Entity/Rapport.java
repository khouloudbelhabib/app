package com.khouloud.auditapp.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rapport {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany
    private List<Risque>risqueList;

    public Rapport(Long id, List<Risque> risqueList) {
        this.id = id;
        this.risqueList = risqueList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Risque> getRisqueList() {
        return risqueList;
    }

    public void setRisqueList(List<Risque> risqueList) {
        this.risqueList = risqueList;
    }
}
