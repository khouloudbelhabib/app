package com.khouloud.auditapp.Service;

import com.khouloud.auditapp.Entity.Evaluation;
import com.khouloud.auditapp.Entity.User;

import java.util.List;

public interface EvaluationService {
    public List<Evaluation> GetAllEvaluation();
    public List<Evaluation>GetAllEvaluationByUser(User user);
    public Evaluation addEvaluation(Evaluation evaluation);
    public boolean deleteEvaluation(Long id);
    public Evaluation updateEvaluation(Evaluation evaluation);
}
