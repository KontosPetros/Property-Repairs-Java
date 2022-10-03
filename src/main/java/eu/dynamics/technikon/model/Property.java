package eu.dynamics.technikon.model;

import java.util.List;

import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Where(clause = "isActive = 1")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true)
	private String propertyID;
	private String address;
	private String yearOfConstruction;
	private TypeOfProperty typeOfProperty;

	@ManyToOne
	@JoinColumn(name = "vatNumber", referencedColumnName = "vatNumber")
	private PropertyOwner propertyOwner;

	@OneToMany(mappedBy = "property")
	private List<PropertyRepair> propertyRepairs;

	private Integer isActive = 1;

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PropertyOwner getPropertyOwner() {
		return propertyOwner;
	}

	public void setPropertyOwner(PropertyOwner propertyOwner) {
		this.propertyOwner = propertyOwner;
	}

	public String getPropertyID() {
		return propertyID;
	}

	public String getAddress() {
		return address;
	}

	public String getYearOfConstruction() {
		return yearOfConstruction;
	}

	public TypeOfProperty getTypeOfProperty() {
		return typeOfProperty;
	}

	public void setPropertyID(String propertyID) {
		this.propertyID = propertyID;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setYearOfConstruction(String yearOfConstruction) {
		this.yearOfConstruction = yearOfConstruction;
	}

	public void setTypeOfProperty(TypeOfProperty typeOfProperty) {
		this.typeOfProperty = typeOfProperty;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", propertyID=" + propertyID + ", address=" + address + ", yearOfConstruction="
				+ yearOfConstruction + ", typeOfProperty=" + typeOfProperty + ", propertyOwner=" + propertyOwner
				+ ", propertyRepairs=" + propertyRepairs + "]";
	}

}
