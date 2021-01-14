package tn.esprit.PidevService.Interf;


import java.util.List;

import javax.ejb.Local;

import tn.esprit.Pidev_Entities.*;

@Local
public interface ProjectServiceLocal {
	public int AddProject(Project project);
	public int AddProject(Project project,User user);
	public void removeProject(int pid);
	public int activate(int pid);
	public Project getProjectById(int id);
	public List<Project> getProjectByOwner(User user);
	public List<Project> getAllProjects();
	public void UpdateProject(Project project);
	public void finishProject(int pid);
	public List<Project> getPendingProjects(User user);
	public List<Project> getOnGoingProjects(User user);
	public List<Project> getFinishedProjects();
	public void deleteProject(int pid);
 
}