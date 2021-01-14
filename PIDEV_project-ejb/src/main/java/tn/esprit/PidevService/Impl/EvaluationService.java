package tn.esprit.PidevService.Impl;

import java.util.Date;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import tn.esprit.PidevService.Interf.EvaluationServiceRemote;
import tn.esprit.Pidev_Entities.*;

@Stateless
@LocalBean
public class EvaluationService implements  EvaluationServiceRemote {
	
	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;

	@Override
	public int ajouterEvaluation(Evaluation EV) {
			em.persist(EV);
		return  EV.getId();
	}
	
	
	
	@Override
	public void updateEvaluation(Evaluation e) {
		em.merge(e);
		
	}
	@Override
	public void deleteEvaluationById(int Eval_id) {
			Evaluation e = em.find(Evaluation.class, Eval_id);	
		em.remove(e);
	}
	
	@Override
	public List<Evaluation> getAllEvaluations() {
		List<Evaluation> ev = em.createQuery("Select e from Evaluation e", Evaluation.class).getResultList();
		return ev;

	}



	public User getUserById(int selectUserById) {
		
		return null;
	}



	@Override
	public Evaluation getEvaluationById(int EvalId) {
		Evaluation evaluation = em.find(Evaluation.class, EvalId);
        return evaluation;
	
	}

	}
