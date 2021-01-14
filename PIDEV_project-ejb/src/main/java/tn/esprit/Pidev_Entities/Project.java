package tn.esprit.Pidev_Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity 
public class Project implements Serializable {
	
	@Id 
	@GeneratedValue( strategy= GenerationType.IDENTITY) 
	@Column
	int id;
	
	private String clientName;
	
	private String title;
	
	private String description;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date startDate ;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date createdAt ;
	
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date deadLine;
	
	
	private int budget;
	
	@Enumerated(EnumType.STRING)
	private State state ;
	
	@ManyToOne
	private User ownedBy;
	
	@OneToMany(mappedBy="project" , cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Task>  tasks;
	
	@OneToMany(mappedBy="project" , cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Bug>  bugs;

	public Project() {
		super();
	}
	
	
	
	
	public Project(String clientName, String title, String description, Date createdAt, Date deadLine, int budget,
			State state, User ownedBy) {
		super();
		this.clientName = clientName;
		this.title = title;
		this.description = description;
		this.createdAt = createdAt;
		this.deadLine = deadLine;
		this.budget = budget;
		this.state = state;
		this.ownedBy = ownedBy;
	}




	public Project(String clientName, String title, String description, Date createdAt, Date deadLine, int budget,
			State state) {
		super();
		this.clientName = clientName;
		this.title = title;
		this.description = description;
		this.createdAt = createdAt;
		this.deadLine = deadLine;
		this.budget = budget;
		this.state = state;
	}



	public Project(int id, String clientName, String title, String description, int budget) {
		super();
		this.id = id;
		this.clientName = clientName;
		this.title = title;
		this.description = description;
		this.budget = budget;
	}




	public Project(int id, String clientName, String title, String description, int budget, State state) {
		super();
		this.id = id;
		this.clientName = clientName;
		this.title = title;
		this.description = description;
		this.budget = budget;
		this.state = state;
	}




	public Project(String clientName, String title, String description, int budget, State state) {
		super();
		this.clientName = clientName;
		this.title = title;
		this.description = description;
		this.budget = budget;
		this.state = state;
	}




	public Project(int id, String clientName, String title, String description, Date startDate, Date createdAt,
			Date deadLine, int budget, State state, User ownedBy) {
		super();
		this.id = id;
		this.clientName = clientName;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.createdAt = createdAt;
		this.deadLine = deadLine;
		this.budget = budget;
		this.state = state;
		this.ownedBy = ownedBy;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getClientName() {
		return clientName;
	}


	public void setClientName(String clientName) {
		this.clientName = clientName;
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




	public int getBudget() {
		return budget;
	}




	public void setBudget(int budget) {
		this.budget = budget;
	}




	public State getState() {
		return state;
	}




	public void setState(State state) {
		this.state = state;
	}




	public User getOwnedBy() {
		return ownedBy;
	}




	public void setOwnedBy(User ownedBy) {
		this.ownedBy = ownedBy;
	}

	public List<Task> getTasks() {
		return tasks;
	}


	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Bug> getBugs() {
		return bugs;
	}


	public void setBugs(List<Bug> bugs) {
		this.bugs = bugs;
	}


	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
