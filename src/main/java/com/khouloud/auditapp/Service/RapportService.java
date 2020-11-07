package com.khouloud.auditapp.Service;

import com.khouloud.auditapp.Entity.Rapport;
import com.khouloud.auditapp.Entity.User;

public interface RapportService {
    public Rapport getRapportByUser(User user);
    public  boolean DeleteRapportById(Long id);
    public Rapport updateRapport(Rapport rapport);
}
