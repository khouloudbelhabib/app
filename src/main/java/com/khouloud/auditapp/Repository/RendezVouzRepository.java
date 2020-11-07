package com.khouloud.auditapp.Repository;

import com.khouloud.auditapp.Entity.RendezVouz;
import com.khouloud.auditapp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RendezVouzRepository extends JpaRepository<RendezVouz,Long> {
    public List<RendezVouz> findByRendezVouzByUser(User user);
}
