package com.khouloud.auditapp.Controller;

import com.khouloud.auditapp.Entity.Evaluation;
import com.khouloud.auditapp.Entity.User;
import com.khouloud.auditapp.Service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;
    @GetMapping("/getEvaluations")
    public List<Exception> listEvaluations() {
        return evaluationService.GetAllEvaluation();
    }
    @GetMapping("/getEvaluationByUser")
    public List<Evaluation> listEvaluationsByUser(@PathVariable User user) {
        return evaluationService.GetAllEvaluationByUser(user);
    }
    @PostMapping("/saveEvaluation")
    public Evaluation save(@RequestBody Evaluation evaluation) {
        return evaluationService.addEvaluation(evaluation);
    }
    @DeleteMapping("/deleteEvaluation/{id}")
    public boolean delete(@PathVariable Long id) {
        return evaluationService.deleteEvaluation(id);}
    @PostMapping("/updateEvaluation")
    public Evaluation update(@RequestBody Evaluation evaluation) {
        return evaluationService.updateEvaluation(evaluation);}
}
