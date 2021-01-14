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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
public class Task implements Serializable {
	
	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY) 
	@Column
	int id;
	
	private String Title;
	
	private String Description;
	
	private int cost;
	
	@Enumerated(EnumType.STRING)
	private Specialite spec;
	
	@Enumerated(EnumType.STRING)
	private State state;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date deadLine;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date createdAt;
	
	@ManyToOne
	private Project project;
	
	@OneToOne(mappedBy="task", cascade = CascadeType.ALL)
	private Assignment assignment;
	


	
	public Task() {
		super();
	}

	

	public Task(int id, String title, String description, int cost, Specialite spec, State state, Date deadLine,
			Date createdAt, Project project, Assignment assignment) {
		super();
		this.id = id;
		Title = title;
		Description = description;
		this.cost = cost;
		this.spec = spec;
		this.state = state;
		this.deadLine = deadLine;
		this.createdAt = createdAt;
		this.project = project;
		this.assignment = assignment;
	}



	public Task(String title, String description, int cost, Specialite spec, State state, Date deadLine,
			Date createdAt,Project project) {
		super();
		Title = title;
		Description = description;
		this.cost = cost;
		this.spec = spec;
		this.state = state;
		this.deadLine = deadLine;
		this.createdAt = createdAt;
		this.project=project;
	}



	public Task(int id, String title, String description, int cost, Specialite spec, State state, Date deadLine,
			Date createdAt) {
		super();
		this.id = id;
		Title = title;
		Description = description;
		this.cost = cost;
		this.spec = spec;
		this.state = state;
		this.deadLine = deadLine;
		this.createdAt = createdAt;
		
	}



	public int getCost() {
		return cost;
	}



	public void setCost(int cost) {
		this.cost = cost;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Specialite getSpec() {
		return spec;
	}

	public void setSpec(Specialite spec) {
		this.spec = spec;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}


	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
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

}