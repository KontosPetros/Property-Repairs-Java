package eu.dynamics.technikon.model;

import java.util.List;

import org.hibernate.annotations.Where;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
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
	private String propertyId;
	private String address;
	private String yearOfConstruction;
	@Enumerated(EnumType.STRING)
	private TypeOfProperty typeOfProperty;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ownerId")
	private PropertyOwner propertyOwner;

	@OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
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

	public String getPropertyId() {
		return propertyId;
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

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
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
		return "Property [id=" + id + ", propertyId=" + propertyId + ", address=" + address + ", yearOfConstruction="
				+ yearOfConstruction + ", typeOfProperty=" + typeOfProperty + ", propertyOwner vatNumber="
				+ propertyOwner.getVatNumber() + "]";
	}

}
