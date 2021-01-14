package tn.esprit.PidevService.Impl;

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
public class TaskService implements TaskServiceRemote ,TaskServiceLocal {
	
	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;
	
	
	public int AddTasks(Project project,Task task)
	{	
		Project p=em.find(Project.class, project.getId());
		task.setProject(p);
		em.persist(task);
 		return task.getId();
	}
	
	public int AddTask(Task task)
	{	
		
		em.persist(task);
 		return task.getId();
	}

	public Task getTasksById(int id){
		TypedQuery<Task> query = em.createQuery("select t from Task t where t.id=:id", Task.class);
		query.setParameter("id", id);
		Task task = null;
		try { task = query.getSingleResult(); }
		catch (Exception

		e) { System.out.println("Erreur : " +
		e); }
		
		return task;
	}
	
	public Task getTaskByUser(User user) {
	//	TypedQuery<Task> query = em.createQuery("", Project.class);
	//	query.setParameter("id", user.id);
	//	List<Project> projects = null;
	//	try { projects = query..getResultList(); }
	//	catch (Exception

	//	e) { System.out.println("Erreur : " +
	//	e); }

	//	return projects;
		return null ;
	}
	
	public List<Task>getTasksByProject(Project project){
         	TypedQuery<Task> query = em.createQuery("select t from Task t where t.project=:id", Task.class);
			query.setParameter("id", em.find(Project.class, project.getId()));
			List<Task> tasks = null;
			try { tasks = query.getResultList(); }
			catch (Exception

			e) { System.out.println("Erreur : " +
			e); }

			return tasks;
	}
	
	public List<Task>getTasksByProject(int pid){
     	TypedQuery<Task> query = em.createQuery("select t from Task t where t.project=:id", Task.class);
		query.setParameter("id", em.find(Project.class, pid));
		List<Task> tasks = null;
		try { tasks = query.getResultList(); }
		catch (Exception

		e) { System.out.println("Erreur : " +
		e); }

		return tasks;
}
	
	public List<Task>getAllTasks(){
		List<Task> tasks = em.createQuery("Select t from Task t", Task.class).getResultList();
		return tasks;
		
	}
	
	
	
	public void UpdateTask(Task task){
		em.merge(task); 
		}
	
	public void removeTask(Task task) {
		Task t =em.find(Task.class, task.getId());
		if (t.getAssignment()==null || t.getState()==State.Pending) {
			em.remove(t);
		}	
	}
	
	public void removeTask(int id) {
		Task t =em.find(Task.class, id);
		if (t.getAssignment()==null || t.getState()==State.Pending) {
			em.remove(t);
		}	
	}

	public void activate(int id) {
		Task t =em.find(Task.class, id);
		if (t.getState()==State.Pending && t.getCost()< t.getProject().getBudget()) {
			t.setState(State.Ongoing);
			Project p = t.getProject();
			p.setBudget(p.getBudget()-t.getCost());
			em.merge(p);
			em.merge(t);
		}	
	}
	
}
