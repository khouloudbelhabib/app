package com.khouloud.auditapp.Controller;

import com.khouloud.auditapp.Entity.RendezVous;
import com.khouloud.auditapp.Entity.User;
import com.khouloud.auditapp.Service.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rendezvous")
public class RendezVouzController {

    @Autowired
    private RendezVousService rendezVousService;


    @GetMapping("/getRendezVous")
    public List<RendezVous> listRendezVouz() {
        return rendezVousService.getAllrendezvouz();
    }
    @GetMapping("/getRendezVousByUser")
    public List<RendezVous> listRendezVouzByUser(@PathVariable User user) {
        return rendezVousService.getAllrendezvouzByUser(user);
    }
    @PostMapping("/save")
    public RendezVous save(@RequestBody RendezVous rendezVous) {
            return rendezVousService.addRendervouz(rendezVous);
    }
    @DeleteMapping("/deleteRendezvouz/{id}")
    public boolean delete(@PathVariable Long id) {
        return rendezVousService.deleteRendezvouz(id);
    }
    @PostMapping("/updateRendezVouz")
    public RendezVous update(@RequestBody RendezVous rendezVous) {
        return rendezVousService.updateRendervouz(rendezVous);}
    @PostMapping("/ajouterunrendezvous")
    public Optional<RendezVous> ajouterrendezvouz (@RequestBody RendezVous rendezVous){
      return   rendezVousService.prendreRendezVous(rendezVous);

    }
    @InitBinder
    public void binder(WebDataBinder binder) {binder.registerCustomEditor(Timestamp.class,
            new PropertyEditorSupport() {
                public void setAsText(String value) {
                    try {
                        Date parsedDate = new SimpleDateFormat("dd.MM.yyyy HH:mm").parse(value);
                        setValue(new Timestamp(parsedDate.getTime()));
                    } catch (ParseException e) {
                        setValue(null);
                    }
                }
            });
    }
}
