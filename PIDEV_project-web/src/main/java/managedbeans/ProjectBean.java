package managedbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.PidevService.Impl.ProjectService;
import tn.esprit.Pidev_Entities.Project;
import tn.esprit.Pidev_Entities.State;
import tn.esprit.Pidev_Entities.User;


@ManagedBean(name="projectBean")
@SessionScoped
public class ProjectBean implements Serializable {
    
	private int budget;
	private String clientName;
	private String title;
	private String description;
	private Date startDate ;
	private Date deadLine ;
	private State state;
	private Date createdAt;
	private User ownedBy;
	
	
	private List<Project> projects;
	private List<Project> pendingProjects;
	private List<Project> onGoingProjects;
	private List<Project> finishedProjects;
	
	private int projectIdToUpdate;
	private int projectIdToManage;
	
	public int getProjectIdToManage() {
		return projectIdToManage;
	}


	public void setProjectIdToManage(int projectIdToManage) {
		this.projectIdToManage = projectIdToManage;
	}


	public List<Project> getFinishedProjects() {
		finishedProjects = ps.getFinishedProjects();
		return finishedProjects;
	}


	public void setFinishedProjects(List<Project> finishedProjects) {
		this.finishedProjects = finishedProjects;
	}


	public List<Project> getPendingProjects() {
		pendingProjects = ps.getPendingProjects(LoginBean.getUser());
		return pendingProjects;
	}


	public void setPendingProjects(List<Project> pendingProjects) {
		this.pendingProjects = pendingProjects;
	}


	public List<Project> getOnGoingProjects() {
		onGoingProjects = ps.getOnGoingProjects(LoginBean.getUser());
		return onGoingProjects;
	}


	public void setOnGoingProjects(List<Project> onGoingProjects) {
		this.onGoingProjects = onGoingProjects;
	}


	@EJB
	ProjectService ps ; 

	public String addProject() {
		System.out.println("test");
		int a = ps.AddProject(new Project(clientName, title, description, new Date(), deadLine, budget,State.Pending,LoginBean.getUser()));
		System.out.println("Project number "+a+" added by "+LoginBean.getUser());
		return "new-project-added?faces-redirect=true";
	}

	
	
	public String remove(Project p) {
		ps.removeProject(p.getId());
		return "Project-Updated?faces-redirect=true";
	}
	
	public String activate(Project p) {
		if (p.getState()==State.Pending && p.getOwnedBy().getId()==LoginBean.getUser().getId()) {
			int r=ps.activate(p.getId());
			System.out.println("project "+r+" has been activated successfully");
			return "Project-Updated?faces-redirect=true";
		}else {
			return "error-update-unauth?faces-redirect=true";
		}	
	}
	
	public String finish(Project p) {
		if (p.getState()==State.Ongoing && p.getOwnedBy().getId()==LoginBean.getUser().getId()) {
			ps.finishProject(p.getId());
			System.out.println("project  has been Finished successfully");
			return "Project-Updated?faces-redirect=true";
		}else {
			return "error-update-unauth?faces-redirect=true";
		}
	}
	
	public String manage(Project p) {
		if (p.getOwnedBy().getId()==LoginBean.getUser().getId()) {
			this.setProjectIdToManage(p.getId());
			System.out.println(this.getProjectIdToManage());
			return "ProjectTasksList?faces-redirect=true";
		}else {
			clear();
			return "error-update-unauth?faces-redirect=true";
		}
		
	}
	
	
	public void clear() {
		this.setDescription("");;
		this.setClientName("");
		this.setTitle("");
		this.setBudget(0);
		this.setDeadLine(null);
		this.setState(null);
		this.setStartDate(null);
		this.setOwnedBy(null);
		this.setCreatedAt(null);
		this.setProjectIdToUpdate(0);
		this.setProjectIdToManage(0);
	}
	
	public void modify(Project project) {
		this.setDescription(project.getDescription());;
		this.setClientName(project.getClientName());
		this.setTitle(project.getTitle());
		this.setBudget(project.getBudget());
		this.setDeadLine(project.getDeadLine());
		this.setState(project.getState());
		this.setStartDate(project.getStartDate());
		this.setOwnedBy(project.getOwnedBy());
		this.setCreatedAt(project.getCreatedAt());
		this.setProjectIdToUpdate(project.getId());
		}
	
	public void updateProject(){
		Project p = ps.getProjectById(getProjectIdToUpdate());
		if (LoginBean.getUser().getId()==p.getOwnedBy().getId()){
			ps.UpdateProject(new Project(projectIdToUpdate,clientName,title,description,startDate,createdAt,deadLine,budget,state,ownedBy));
			clear();
		}else {
			clear();
		}
		}

	public String getClientName() {
		return clientName;
	}


	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	public String getDescription(){
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public ProjectBean() {
		
	}

	public int getBudget() {
		return budget;
	}



	public void setBudget(int budget) {
		this.budget = budget;
	}


	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public ProjectService getPs() {
		return ps;
	}



	public void setPs(ProjectService ps) {
		this.ps = ps;
	}


	public List<Project> getProjects() {
		projects = ps.getAllProjects();
		return projects;
	}


	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}


	public int getProjectIdToUpdate() {
		return projectIdToUpdate;
	}


	public void setProjectIdToUpdate(int projectIdToUpdate) {
		this.projectIdToUpdate = projectIdToUpdate;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getDeadLine() {
		return deadLine;
	}


	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}


	public State getState() {
		return state;
	}


	public void setState(State state) {
		this.state = state;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public User getOwnedBy() {
		return ownedBy;
	}


	public void setOwnedBy(User ownedBy) {
		this.ownedBy = ownedBy;
	}
	
	
	

}