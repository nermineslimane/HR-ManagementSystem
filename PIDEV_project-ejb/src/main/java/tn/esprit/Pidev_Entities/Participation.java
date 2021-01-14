package tn.esprit.Pidev_Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import EntityBase.AbstractTimestampEntity;
import EntityBase.IBaseEntity;


@Entity
public class Participation extends AbstractTimestampEntity implements Serializable, IBaseEntity{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idParticpant;

private static final long serialVersionUID = 35501844688441792L;

private String etat;

@ManyToOne
@JoinColumn(name= "idMission")	
	private Mission mission ;

@ManyToOne
@JoinColumn(name= "idUser")		
private User user ;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateParticipation;

	

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDateParticipation() {
		return dateParticipation;
	}

	public void setDateParticipation(Date dateParticipation) {
		this.dateParticipation = dateParticipation;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
