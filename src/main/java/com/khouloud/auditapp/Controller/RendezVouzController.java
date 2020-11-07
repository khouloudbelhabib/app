package com.khouloud.auditapp.Controller;

import com.khouloud.auditapp.Entity.RendezVouz;
import com.khouloud.auditapp.Entity.User;
import com.khouloud.auditapp.Service.RendezvouzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rendezvouz")
public class RendezVouzController {
    @Autowired
    private RendezvouzService rendezvouzService;
    @GetMapping("/getRendezVous")
    public List<RendezVouz> listRendezVouz() {
        return rendezvouzService.getAllrendezvouz();
    }
    @GetMapping("/getRendezVousByUser")
    public List<RendezVouz> listRendezVouzByUser( @PathVariable User user) {
        return rendezvouzService.getAllrendezvouzByUser(user);
    }
    @PostMapping("/saveRendezVouz")
    public RendezVouz save(@RequestBody RendezVouz rendezVouz) {
        return rendezvouzService.addRendervouz(rendezVouz);
    }
    @DeleteMapping("/deleteRendezvouz/{id}")
    public boolean delete(@PathVariable Long id) {
        return rendezvouzService.deleteRendezvouz(id);
    }
    @PostMapping("/updateRendezVouz")
    public RendezVouz update(@RequestBody RendezVouz rendezVouz) {
        return rendezvouzService.updateRendervouz(rendezVouz);}

}
