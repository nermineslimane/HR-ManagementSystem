package tn.esprit.Pidev_Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity 

public class Reactp implements Serializable{
	@Id 
	@GeneratedValue( strategy= GenerationType.IDENTITY) 
	@Column
	int id; 
	@ManyToOne
	private User user;
	@ManyToOne
	private Publication publication;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Publication getPublication() {
		return publication;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	
}
