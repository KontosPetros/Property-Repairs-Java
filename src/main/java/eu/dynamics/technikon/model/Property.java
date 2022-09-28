package eu.dynamics.technikon.model;

import eu.dynamics.technikon.domain.TypeOfProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Property {

	@Id
	private String propertyID;
	private String address;
	private String yearOfConstruction;
	private TypeOfProperty typeOfProperty;
	private String vatNumber;

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

	public String getVatNumber() {
		return vatNumber;
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

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

}
