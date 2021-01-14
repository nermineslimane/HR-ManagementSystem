package tn.esprit.Pidev_Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity 

public class Publication implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue( strategy= GenerationType.IDENTITY) 
	@Column
	int id; 
	@Temporal(TemporalType.DATE)
	@Column
	private Date date ;
	@Column
	String statut; 
	@Column
	String file;
	@ManyToOne
	private User user;
	@OneToMany(mappedBy="publication", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Feedback>  feedback ;
	@OneToMany(mappedBy="publication", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Reactp> reactp ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public List<Feedback> getFeedback() {
		return feedback;
	}
	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}
	
	public List<Reactp> getReactp() {
		return reactp;
	}
	public void setReactp(List<Reactp> reactp) {
		this.reactp = reactp;
	}
	@Override
	public String toString() {
		return "Publication [id=" + id + ", date=" + date + ", statut=" + statut + ", file=" + file + ", user=" + user
				+ "]";
	}

}
