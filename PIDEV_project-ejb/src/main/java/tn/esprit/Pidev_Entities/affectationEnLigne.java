package tn.esprit.Pidev_Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class affectationEnLigne implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column
	private int participationId ;
	
	@ManyToOne
	private formationEnLigne formationEnLigne;
	
	@ManyToOne
	private  User users;
	
	@Column
	private Integer score ;
	@Column
	private Integer niveau ;
	
	public int getParticipationId() {
		return participationId;
	}
	public void setParticipationId(int participationId) {
		this.participationId = participationId;
	}
	
	public formationEnLigne getFormationEnLigne() {
		return formationEnLigne;
	}
	public void setFormationEnLigne(formationEnLigne formationEnLigne) {
		this.formationEnLigne = formationEnLigne;
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getNiveau() {
		return niveau;
	}
	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public affectationEnLigne(int participationId, formationEnLigne formationEnLigne, User users, Integer score,
			Integer niveau) {
		super();
		this.participationId = participationId;
		this.formationEnLigne = formationEnLigne;
		this.users = users;
		this.score = score;
		this.niveau = niveau;
	}
	public affectationEnLigne() {
	}
	
}
