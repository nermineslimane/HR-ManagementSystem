package tn.esprit.Pidev_Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;

import EntityBase.AbstractTimestampEntity;
import EntityBase.IBaseEntity;

@Entity
@XmlRootElement
public class Mission extends AbstractTimestampEntity implements Serializable, IBaseEntity {

	private static final long serialVersionUID = 35501844688441792L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private String location;
	
	
	private String dateStart;

	
	private String dateEnd;
	@ManyToOne(fetch = FetchType.EAGER)
	private User assignee;

	@Enumerated(EnumType.STRING)
	@Column(name = "Specialite")
	private Specialite specialite;

	/*
	 * @OneToMany(mappedBy ="mission",cascade =CascadeType.PERSIST) private
	 * List<Participation> users ;
	 */

	/*
	 * @OneToMany
	 * 
	 * @JoinColumn(name = "id") private User user;
	 */

	public Mission() {
		super();
	}

	public Mission(String name, String description, Specialite specialite, String location, String dateStart,
			String dateEnd) {
		this.name = name;
		this.description = description;
		this.location = location;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.specialite = specialite;
	}

	public Mission(int id, String name, String description) {

		this.id = id;
		this.name = name;
		this.description = description;

	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	public Mission(int id, String name, String description, String location, String dateStart, String dateEnd,
			User assignee, Specialite specialite) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.location = location;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.assignee = assignee;
		this.specialite = specialite;
	}

	public Mission(int id, String name, String description, String location, String dateStart, String dateEnd,
			Specialite specialite) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.location = location;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.specialite = specialite;
	}

	public Mission(String name, String description, Specialite specialite) {
		this.name = name;
		this.description = description;
		this.specialite = specialite;
	}

	public int getId() {
		return id;
	}

	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	@XmlElement
	public void setLocation(String location) {
		this.location = location;
	}

	public String getDateStart() {
		return dateStart;
	}

	@XmlElement
	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	@XmlElement
	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((assignee == null) ? 0 : assignee.hashCode());
		result = prime * result + ((dateEnd == null) ? 0 : dateEnd.hashCode());
		result = prime * result + ((dateStart == null) ? 0 : dateStart.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((specialite == null) ? 0 : specialite.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mission other = (Mission) obj;
		if (assignee == null) {
			if (other.assignee != null)
				return false;
		} else if (!assignee.equals(other.assignee))
			return false;
		if (dateEnd == null) {
			if (other.dateEnd != null)
				return false;
		} else if (!dateEnd.equals(other.dateEnd))
			return false;
		if (dateStart == null) {
			if (other.dateStart != null)
				return false;
		} else if (!dateStart.equals(other.dateStart))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (specialite != other.specialite)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mission [id=" + id + ", name=" + name + ", description=" + description + ", location=" + location
				+ ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + ", assignee=" + assignee + ", specialite="
				+ specialite + "]";
	}

	/*
	 * public List<Participation> getUsers() { return users; }
	 * 
	 * public void setUsers(List<Participation> participation) { this.users =
	 * participation; }
	 */

}
