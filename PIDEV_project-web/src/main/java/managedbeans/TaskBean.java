package managedbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import tn.esprit.PidevService.Impl.ProjectService;
import tn.esprit.PidevService.Impl.TaskService;
import tn.esprit.Pidev_Entities.Assignment;
import tn.esprit.Pidev_Entities.Project;
import tn.esprit.Pidev_Entities.Specialite;
import tn.esprit.Pidev_Entities.State;
import tn.esprit.Pidev_Entities.Task;


@ManagedBean(name="taskBean")
@SessionScoped
public class TaskBean implements Serializable {

	@EJB
	TaskService ts; 
	
	@EJB
	ProjectService ps; 
	
	@ManagedProperty(value="#{projectBean}")
	private ProjectBean projectBean;
	
	private String title;
	private String description;
	private Specialite spec;
	private State state;
	private Date deadLine;
	private Date createdAt;
	private int cost;
	private Project project;
	private Assignment assignment;
	private int taskIdToUpdate;
	private Task task;
	
	
	private List<Task> tasks;
	
	
	public TaskBean() {
		
	}
	
	@PostConstruct
	public void init() {
		this.project=ps.getProjectById(projectBean.getProjectIdToManage());
		if (this.project==null) {
			this.project=ps.getProjectById(1);
			this.task=this.project.getTasks().get(0);
		}
	}
	
	public void addTask() {
		System.out.println("test adding task");
		if (this.project.getState()==State.Pending) {
			ps.activate(this.project.getId());
			System.out.println("Project activated");
		}
		if (this.cost<this.project.getBudget()) {
			ts.AddTask(new Task(title,description,cost,spec,State.Pending,deadLine,new Date(),this.project));
			this.getProject().setBudget(this.project.getBudget()-cost);
			ps.UpdateProject(this.project);
			System.out.println("Project number  added by "+LoginBean.getUser());
		}	
	}
	
	public void remove(Task item) {
		if (item.getState()==State.Pending) {
			ts.removeTask(item);
		}
	}
	
	public String manage(Task t) {
		if (LoginBean.getUser().getId()==t.getProject().getOwnedBy().getId() && (t.getState()==State.Pending)) {
			this.setTaskIdToUpdate(t.getId());
			System.out.println(this.getTaskIdToUpdate());
			modify(t);
			return "ModifyTask?faces-redirect=true";
		}else {
			
			return "error-update-unauth?faces-redirect=true";
		}
		
	}
	
	
	public void modify(Task task) {
		this.setTitle(task.getTitle());
		this.setDescription(task.getDescription());
		this.setSpec(task.getSpec());
		this.setState(task.getState());
		this.setDeadLine(task.getDeadLine());
		this.setCreatedAt(task.getCreatedAt());
		this.setCost(task.getCost());
		this.setAssignment(task.getAssignment());
		this.setProject(task.getProject());
		this.setTaskIdToUpdate(task.getId());
		this.task=task;
		}
	
	
	public void updateTask(){
		System.out.println(taskIdToUpdate);
		Task t = ts.getTasksById(taskIdToUpdate);
		System.out.println(t.toString());
		if (LoginBean.getUser().getId()==t.getProject().getOwnedBy().getId() && (t.getState()==State.Pending)){
			System.out.println("here wselna /////////////////");
        ts.UpdateTask(new Task(taskIdToUpdate,title,description,cost,spec,state,deadLine,createdAt,project,assignment));
		}
		}
	
	
	public String activateTask(Task t) {
		if (LoginBean.getUser().getId()==t.getProject().getOwnedBy().getId() && t.getCost()<this.project.getBudget()) {
			ts.activate(t.getId());
			return"ProjectTaskList?faces-redirect-true";
		}	else {
			
			return "error-update-unauth?faces-redirect=true";
		}
		
		
	}
	
   
	public TaskService getTs() {
		return ts;
	}

	public void setTs(TaskService ts) {
		this.ts = ts;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public int getTaskIdToUpdate() {
		return taskIdToUpdate;
	}

	public void setTaskIdToUpdate(int taskIdToUpdate) {
		this.taskIdToUpdate = taskIdToUpdate;
	}

	public List<Task> getTasks() {
		this.project=ps.getProjectById(projectBean.getProjectIdToManage());
		if (this.project==null) {
			this.project=ps.getProjectById(1);
		}
		return ts.getTasksByProject(this.project);
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
		}

	public ProjectService getPs() {
		return ps;
	}

	public void setPs(ProjectService ps) {
		this.ps = ps;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public ProjectBean getProjectBean() {
		return projectBean;
	}

	public void setProjectBean(ProjectBean projectBean) {
		this.projectBean = projectBean;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public Specialite getSpec() {
		return spec;
	}

	public void setSpec(Specialite spec) {
		this.spec = spec;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
}