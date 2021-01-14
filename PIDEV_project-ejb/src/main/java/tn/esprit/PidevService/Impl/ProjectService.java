package tn.esprit.PidevService.Impl;


import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.PidevService.Interf.*;
import tn.esprit.Pidev_Entities.*;


@Stateless
@LocalBean
public class ProjectService implements ProjectServiceRemote ,ProjectServiceLocal {
	
	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;
	
	
	public int AddProjects(Project project)
	{	
		
		em.persist(project);
 		return project.getId();
	}
	
	public int AddProject(Project project)
	{	
		User u = em.find(User.class,project.getOwnedBy().getId());				
		em.persist(project);
		System.out.println("Project added successfully (with User)");
		return project.getId();		
	}
	
	
	public int AddProject(Project project,User user)
	{		
		User u = em.find(User.class, user.getId());				
					project.setOwnedBy(u);
					em.persist(project);
					System.out.println("Project added successfully (with User)");
					return project.getId();		
			}
	
	
//----------------------------------------------------------------------------	
	
	
	public Project getProjectById(int id) {
		TypedQuery<Project> query = em.createQuery("select p from Project p where p.id=:id", Project.class);
		query.setParameter("id", id);
		Project project = null;
		try { project = query.getSingleResult(); }
		catch (Exception

		e) { System.out.println("Erreur : " +
		e); }

		return project;
	}
	
	
	public List<Project> getAllProjects() {
		List<Project> project = em.createQuery("Select p from Project p", Project.class).getResultList();
		return project;
		}
	
	public List<Project> getProjectByOwner(User user) {
		TypedQuery<Project> query = em.createQuery("select p from Project p where p.ownedBy=:id", Project.class);
		query.setParameter("id", em.find(User.class, user.getId()));
		List<Project> projects = null;
		try { projects = query.getResultList(); }
		catch (Exception

		e) { System.out.println("Erreur : " +
		e); }

		return projects;
	}
	
	
	public void UpdateProject(Project project) 
	   {
		em.merge(project); 
		}
	
	


	@Override
	public void removeProject(int pid) {
		Project p = em.find(Project.class,pid);
		if(p.getState()==State.Pending) {
			em.remove(p);
		}
		
	}
	
	public void deleteProject(int pid) {
		Project p = em.find(Project.class,pid);
		
			em.remove(p);
		
		
	}
	
	
	public void finishProject(int pid) {
		Project p = em.find(Project.class,pid);
		p.setState(State.Finished);
		for (Task t : p.getTasks()) {
			t.setState(State.Finished);
		}
		em.merge(p);
	}
	
	public int activate(int pid) {
		Project p = em.find(Project.class,pid);
		if (p.getState()==State.Pending) {
			p.setState(State.Ongoing);
			p.setStartDate(new Date());
			em.merge(p);
			return p.getId();
		}
		return -1;
		
	}


	@Override
	public List<Project> getPendingProjects(User user) {
		TypedQuery<Project> query = em.createQuery("select p from Project p where p.state=:state and  p.ownedBy=:id", Project.class);
		query.setParameter("state", State.Pending).setParameter("id", em.find(User.class, user.getId()));
		List<Project> projects = null;
		try { projects = query.getResultList(); }
		catch (Exception

		e) { System.out.println("Erreur : " +
		e); }

		return projects;
	}


	@Override
	public List<Project> getOnGoingProjects(User user) {
		TypedQuery<Project> query = em.createQuery("select p from Project p where p.state=:state and  p.ownedBy=:id", Project.class);
		query.setParameter("state", State.Ongoing).setParameter("id", em.find(User.class, user.getId()));
		List<Project> projects = null;
		try { projects = query.getResultList(); }
		catch (Exception

		e) { System.out.println("Erreur : " +
		e); }

		return projects;
	}
	
	
	@Override
	public List<Project> getFinishedProjects() {
		TypedQuery<Project> query = em.createQuery("select p from Project p where p.state=:state", Project.class);
		query.setParameter("state", State.Finished);
		List<Project> projects = null;
		try { projects = query.getResultList(); }
		catch (Exception

		e) { System.out.println("Erreur : " +
		e); }

		return projects;
	}

}
