package tn.esprit.PidevService.Interf;


import java.util.List;

import javax.ejb.Remote;

import tn.esprit.Pidev_Entities.*;

@Remote
public interface TaskServiceRemote {
	public int AddTasks(Project project,Task task);
	public int AddTask(Task task);
	public Task getTasksById(int id);
	public Task getTaskByUser(User user);
	public List<Task> getTasksByProject(Project project);
	public void UpdateTask(Task task);
	public void removeTask(Task task);
	public void removeTask(int id);
	public void activate(int id);
	public List<Task>getAllTasks();
	public List<Task>getTasksByProject(int pid);
}