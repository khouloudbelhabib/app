package com.khouloud.auditapp.Repository;

import com.khouloud.auditapp.entities.Risque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository
public interface RisqueRepository extends JpaRepository<Risque,Long> {
}
