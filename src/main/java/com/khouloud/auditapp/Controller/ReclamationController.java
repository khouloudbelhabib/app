package com.khouloud.auditapp.Controller;

import com.khouloud.auditapp.Entity.Reclamation;
import com.khouloud.auditapp.Entity.User;
import com.khouloud.auditapp.Service.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reclamation")
public class ReclamationController {
    @Autowired
    private ReclamationService reclamationService;
    @GetMapping("/getReclamations")
    public List<Reclamation> listRendezVouz() {
        return reclamationService.getAllReclamation();
    }
    @GetMapping("/getReclamationByUser")
    public List<Reclamation> listRendezVouzByUser(@PathVariable User user) {
        return reclamationService.getAllreclamationByUser(user);
    }
    @PostMapping("/saveReclamation")
    public Reclamation save(@RequestBody Reclamation reclamation) {
        return reclamationService.addReclamation(reclamation);
    }
    @DeleteMapping("/deleteReclamation/{id}")
    public boolean delete(@PathVariable Long id) {
        return reclamationService.deleteReclamation(id);}
}
