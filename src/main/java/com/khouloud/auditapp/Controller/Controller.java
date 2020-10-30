package com.khouloud.auditapp.Controller;

import com.khouloud.auditapp.Repository.UserRepository;
import com.khouloud.auditapp.Repository.RisqueRepository;
import com.khouloud.auditapp.Repository.RoleRepository;
import com.khouloud.auditapp.entities.Risque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RisqueRepository risqueRepository;
    @Autowired
    private RoleRepository roleRepository;
    @GetMapping("/risques")
    public List<Risque> listRisque(){
        return risqueRepository.findAll();
    }
    @PostMapping("/risques")
    public Risque Save( @RequestBody  Risque R){
        return risqueRepository.save(R);
    }
}
