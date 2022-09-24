package eu.dynamics.technikon.domain;

public class Property {
	String propertyID;
	String address;
	String yearOfConstruction;
	TypeOfProperty typeOfProperty;
	String vatNumber;

	public Property(String propertyID, String address, String yearOfConstruction, TypeOfProperty typeOfProperty,
			String vatNumber) {
		super();
		this.propertyID = propertyID;
		this.address = address;
		this.yearOfConstruction = yearOfConstruction;
		this.typeOfProperty = typeOfProperty;
		this.vatNumber = vatNumber;
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

	@Override
	public String toString() {
		return "Property [propertyID=" + propertyID + ", address=" + address + ", yearOfConstruction="
				+ yearOfConstruction + ", typeOfProperty=" + typeOfProperty + ", vatNumber=" + vatNumber + "]";
	}

}
