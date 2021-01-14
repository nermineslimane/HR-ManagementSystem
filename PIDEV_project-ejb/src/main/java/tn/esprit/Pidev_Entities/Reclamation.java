package tn.esprit.Pidev_Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Reclamation implements Serializable{
	private static final long serialVersionUID = -1396669830860400871L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column
	int ReclmationID;
	@Column
	private String titreclaim;
	@Column
	private String descp;
	@Column
	private String fich;
	@Column
	private Statut statut ;
	@Column
	@Temporal
	(TemporalType.DATE)
	private Date dateopen;
	@Column
	@Temporal
	(TemporalType.DATE)
	private Date dateclose;
	@Column
	private String reponse;
	@Column
	private String comment;
	
	public int getReclmationID() {
		return ReclmationID;
	}
	
	public void setReclmationID(int reclmationID) {
		this.ReclmationID = reclmationID;
	}
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
	public Statut getStatut() {
		return statut;
	}
	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	
	public String getTitreclaim() {
		return titreclaim;
	}
	public void setTitreclaim(String titreclaim) {
		this.titreclaim = titreclaim;
	}
	public Date getDateopen() {
		return dateopen;
	}
	public void setDateopen(Date dateopen) {
		this.dateopen = dateopen;
	}
	public Date getDateclose() {
		return dateclose;
	}
	public void setDateclose(Date dateclose) {
		this.dateclose = dateclose;
	}
	public Evaluation getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	} 
	
	        
	@ManyToOne
	private User user;


	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn( referencedColumnName = "id")
    private Evaluation evaluation;
	
}
