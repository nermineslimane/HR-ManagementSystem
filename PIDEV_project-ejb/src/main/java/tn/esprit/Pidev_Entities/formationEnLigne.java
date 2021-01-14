package tn.esprit.Pidev_Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class formationEnLigne implements Serializable {
	
public formationEnLigne() {
		
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column
	private int formationElLigneId ;
	@Column
	private String titre ;
	@Column
	private String image ;
	@Column
	private String objectifs ;
	@ManyToOne
	private Formateur formateur;
	@ManyToOne
	@JoinColumn(nullable = true)
	private User user ;
	
	
	@OneToMany(mappedBy = "formationEnLigne")
	private List<affectationEnLigne> affectation;
	
	@OneToMany(mappedBy = "formationEnLigne")
	@JsonBackReference
	private List<qcm> qcm;
	@OneToMany(mappedBy = "formationEnLign")
	@JsonBackReference
	private List<cours> cour;

	public int getFormationElLigneId() {
		return formationElLigneId;
	}

	public void setFormationElLigneId(int formationElLigneId) {
		this.formationElLigneId = formationElLigneId;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	

	public String getObjectifs() {
		return objectifs;
	}

	public void setObjectifs(String objectifs) {
		this.objectifs = objectifs;
	}

	

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
//	public List<Affectation> getAffectation() {
//		return affectation;
//	}
//
//	public void setAffectation(List<Affectation> affectation) {
//		this.affectation = affectation;
//	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	public List<affectationEnLigne> getAffectation() {
		return affectation;
	}

	public void setAffectation(List<affectationEnLigne> affectation) {
		this.affectation = affectation;
	}

	public List<qcm> getQcm() {
		return qcm;
	}

	public void setQcm(List<qcm> qcm) {
		this.qcm = qcm;
	}

	public List<cours> getCour() {
		return cour;
	}

	public void setCour(List<cours> cour) {
		this.cour = cour;
	}

	public formationEnLigne(int formationElLigneId, String titre, String image, String objectifs, Formateur formateur,
			User user, List<affectationEnLigne> affectation, List<tn.esprit.Pidev_Entities.qcm> qcm, List<cours> cour) {
		super();
		this.formationElLigneId = formationElLigneId;
		this.titre = titre;
		this.image = image;
		this.objectifs = objectifs;
		this.formateur = formateur;
		this.user = user;
		this.affectation = affectation;
		this.qcm = qcm;
		this.cour = cour;
	}

	
	
	
}
