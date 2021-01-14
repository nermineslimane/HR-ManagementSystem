package tn.esprit.Pidev_Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import EntityBase.AbstractTimestampEntity;
import EntityBase.IBaseEntity;


@Entity
public class Report  extends AbstractTimestampEntity implements Serializable, IBaseEntity {

	private static final long serialVersionUID = 35501844688441792L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double price;
	private String description;

	@Temporal(TemporalType.DATE)
	private Date date;
	private String Image;

	private String nature;
	private String state;
	private double rembourssement;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn( nullable = true, insertable = false, updatable = false)
	private Mission id_M;

	public Report(int id, String name, double price, String description, String nature, String state,
			Date date, String image, Mission id_M) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.nature = nature;
		this.state = state;
		this.date = date;
		Image = image;
		this.id_M = id_M;
	}

	public Report() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public Mission getId_M() {
		return id_M;
	}

	public void setId_M(Mission id_M) {
		this.id_M = id_M;
	}

}
