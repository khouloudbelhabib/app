package com.khouloud.auditapp.Controller;

import com.khouloud.auditapp.Entity.RendezVous;
import com.khouloud.auditapp.Entity.User;
import com.khouloud.auditapp.Service.RendezvouzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rendezvous")
public class RendezVouzController {

    @Autowired
    private RendezvouzService rendezvouzService;


        @GetMapping("/getRendezVous")
    public List<RendezVous> listRendezVouz() {
        return rendezvouzService.getAllrendezvouz();
    }
    @GetMapping("/getRendezVousByUser")
    public List<RendezVous> listRendezVouzByUser(@PathVariable User user) {
        return rendezvouzService.getAllrendezvouzByUser(user);
    }
    @PostMapping("/save")
    public RendezVous save(@RequestBody RendezVous rendezVous) {
        return rendezvouzService.addRendervouz(rendezVous);
    }
    @DeleteMapping("/deleteRendezvouz/{id}")
    public boolean delete(@PathVariable Long id) {
        return rendezvouzService.deleteRendezvouz(id);
    }
    @PostMapping("/updateRendezVouz")
    public RendezVous update(@RequestBody RendezVous rendezVous) {
        return rendezvouzService.updateRendervouz(rendezVous);}
    @PostMapping("/ajouterunrendezvous")
    public Optional<RendezVous> ajouterrendezvouz (@RequestBody RendezVous rendezVous){
      return   rendezvouzService.p(rendezVous);

    }
}
