package tn.esprit.Pidev_Entities;

import java.awt.TextArea;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class cours implements Serializable {
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column
	private int courId ;
	@Column
	private String titre ;
	@Column
	private String cour ;
	@Column
	private String video ;
	@ManyToOne
	private formationEnLigne formationEnLign;
	
	
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public cours(int courId, String titre, String cour, String video, formationEnLigne formationEnLign) {
		super();
		this.courId = courId;
		this.titre = titre;
		this.cour = cour;
		this.video = video;
		this.formationEnLign = formationEnLign;
	}
	public int getCourId() {
		return courId;
	}
	public void setCourId(int courId) {
		this.courId = courId;
	}
	public String getCour() {
		return cour;
	}
	public void setCour(String cour) {
		this.cour = cour;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public formationEnLigne getFormationEnLign() {
		return formationEnLign;
	}
	public void setFormationEnLign(formationEnLigne formationEnLign) {
		this.formationEnLign = formationEnLign;
	}
	public cours() {
		
	}
	
}
