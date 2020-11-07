package com.khouloud.auditapp.Service;

import com.khouloud.auditapp.Entity.Reclamation;
import com.khouloud.auditapp.Entity.User;

import java.util.List;

public interface ReclamationService {
    public List<Reclamation> getAllReclamation();
    public List<Reclamation> getAllreclamationByUser(User user);
    public Reclamation addReclamation(Reclamation reclamation);
    public boolean deleteReclamation(Long id);
}
