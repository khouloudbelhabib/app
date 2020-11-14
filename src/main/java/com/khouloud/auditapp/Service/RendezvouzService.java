package com.khouloud.auditapp.Service;

import com.khouloud.auditapp.Entity.RendezVous;
import com.khouloud.auditapp.Entity.User;

import java.util.List;
import java.util.Optional;

public interface RendezvouzService {
    public List<RendezVous> getAllrendezvouz();
    public List<RendezVous> getAllrendezvouzByUser(User user);
    public RendezVous addRendervouz(RendezVous rendezVous);
    public RendezVous updateRendervouz(RendezVous rendezVous);
    public boolean deleteRendezvouz(Long id);
    public Optional<RendezVous> prendreunrendezvous (RendezVous rendezVous);
}
