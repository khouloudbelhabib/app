package com.khouloud.auditapp.Controller;

import com.khouloud.auditapp.Entity.Risque;
import com.khouloud.auditapp.Service.RisqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/risques")
public class RisqueController {

    @Autowired
    private RisqueService risqueService;

    @GetMapping("/get")
    public List<Risque> listRisque() {
        return risqueService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public Risque get(@PathVariable Long id) throws Exception {
        return risqueService.get(id);
    }

    @PostMapping("/save")
    public Risque save(@RequestBody Risque risque) {
        return risqueService.save(risque);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return risqueService.delete(id);
    }
}
