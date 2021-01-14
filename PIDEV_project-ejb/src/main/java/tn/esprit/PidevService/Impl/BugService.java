package tn.esprit.PidevService.Impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.PidevService.Interf.BugServiceLocal;
import tn.esprit.PidevService.Interf.BugServiceRemote;
import tn.esprit.Pidev_Entities.Bug;



public class BugService implements BugServiceRemote ,BugServiceLocal {
	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;
	
	
	
	@Override
	public int AddBug(Bug bug) {
		
		em.merge(bug);
		return bug.getId();

	}

	@Override
	public int UpdateBug(Bug bug) {
		Bug bgg=em.find(Bug.class, bug.getId());
		em.merge(bgg);
		return bgg.getId();
	}

	@Override
	public Bug getBugById(int id) {
		Bug bgg=em.find(Bug.class, id);
		return bgg;
	}

	@Override
	public List<Bug> getAll() {
		List<Bug> eqp = em.createQuery("Select e from Bug e", Bug.class).getResultList();
		return eqp;
	}

	@Override
	public void removeBug(int id) {
		Bug bgg=em.find(Bug.class, id);
		em.remove(bgg);
		
	}

}
