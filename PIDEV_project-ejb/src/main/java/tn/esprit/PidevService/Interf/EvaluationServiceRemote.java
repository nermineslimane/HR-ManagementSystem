package tn.esprit.PidevService.Interf;


import java.util.List;


import javax.ejb.Remote;

import tn.esprit.Pidev_Entities.Evaluation;;



@Remote
public interface EvaluationServiceRemote {
	public List<Evaluation> getAllEvaluations();
	public void updateEvaluation(Evaluation e);
	public int ajouterEvaluation(Evaluation EV);
	public void deleteEvaluationById(int Eval_id);
	public Evaluation getEvaluationById(int EvalId) ;
	
}
