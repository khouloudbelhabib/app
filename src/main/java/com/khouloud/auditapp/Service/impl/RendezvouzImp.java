package com.khouloud.auditapp.Service.impl;

import com.khouloud.auditapp.Entity.RendezVous;
import com.khouloud.auditapp.Entity.User;
import com.khouloud.auditapp.Repository.RendezVouzRepository;
import com.khouloud.auditapp.Service.RendezvouzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class RendezvouzImp  implements RendezvouzService {
    @Autowired
    private RendezVouzRepository rendezVouzRepository;
    @Override
    public List<RendezVous> getAllrendezvouz() {
        return rendezVouzRepository.findAll();
    }

    @Override
    public List<RendezVous> getAllrendezvouzByUser(User user) {
        return rendezVouzRepository.findByUser(user);
    }

    @Override
    public RendezVous addRendervouz(RendezVous rendezVous) {
        return rendezVouzRepository.save(rendezVous);

    }

    @Override
    public RendezVous updateRendervouz(RendezVous rendezVous) {
        return rendezVouzRepository.save(rendezVous);

    }



    @Override
    public boolean deleteRendezvouz(Long id) {
        Assert.notNull(id);
        try {
           rendezVouzRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
