package com.khouloud.auditapp.Service;

import com.khouloud.auditapp.Entity.RendezVouz;
import com.khouloud.auditapp.Entity.User;

import java.util.List;

public interface RendezvouzService {
    public List<RendezVouz> getAllrendezvouz();
    public List<RendezVouz> getAllrendezvouzByUser(User user);
    public RendezVouz addRendervouz(RendezVouz rendezVouz);
    public RendezVouz updateRendervouz(RendezVouz rendezVouz);
    public boolean deleteRendezvouz(Long id);
}
