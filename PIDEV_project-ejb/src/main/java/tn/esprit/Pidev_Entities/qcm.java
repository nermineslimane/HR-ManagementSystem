package tn.esprit.Pidev_Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class qcm implements Serializable{
public qcm() {
		
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column
	private int qcmId;
	@Column
	private String Qtext ;
	@Column
	private String COP ;
	@Column
	private String OPA ;
	@Column
	private String OPB ;
	@Column
	private String OPC ;
	@Column
	private String OPD ;
	
	@ManyToOne
	@JoinColumn(nullable = true)
	private formationEnLigne formationEnLigne ;
	
	@Column
	private Specialite Specialite;
	
	public int getQcmId() {
		return qcmId;
	}
	public void setQcmId(int qcmId) {
		this.qcmId = qcmId;
	}
	
	public formationEnLigne getQsm() {
		return formationEnLigne;
	}
	public void setQsm(formationEnLigne formationEnLigne) {
		this.formationEnLigne = formationEnLigne;
	}
	public formationEnLigne getFormationEnLigne() {
		return formationEnLigne;
	}
	public void setFormationEnLigne(formationEnLigne formationEnLigne) {
		this.formationEnLigne = formationEnLigne;
	}
	public Specialite getSpecialite() {
		return Specialite;
	}
	public void setSpecialite(Specialite specialite) {
		Specialite = specialite;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getQtext() {
		return Qtext;
	}
	public void setQtext(String qtext) {
		Qtext = qtext;
	}
	public String getCOP() {
		return COP;
	}
	public void setCOP(String cOP) {
		COP = cOP;
	}
	public String getOPA() {
		return OPA;
	}
	public void setOPA(String oPA) {
		OPA = oPA;
	}
	public String getOPB() {
		return OPB;
	}
	public void setOPB(String oPB) {
		OPB = oPB;
	}
	public String getOPC() {
		return OPC;
	}
	public void setOPC(String oPC) {
		OPC = oPC;
	}
	public String getOPD() {
		return OPD;
	}
	public void setOPD(String oPD) {
		OPD = oPD;
	}
	public qcm(int qcmId, String qtext, String cOP, String oPA, String oPB, String oPC, String oPD,
			tn.esprit.Pidev_Entities.formationEnLigne formationEnLigne,
			tn.esprit.Pidev_Entities.Specialite specialite) {
		super();
		this.qcmId = qcmId;
		Qtext = qtext;
		COP = cOP;
		OPA = oPA;
		OPB = oPB;
		OPC = oPC;
		OPD = oPD;
		this.formationEnLigne = formationEnLigne;
		Specialite = specialite;
	}
	
	

}
