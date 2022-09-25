package eu.dynamics.technikon.domain;

public class Property implements Entity{
	private String propertyID;
	private String address;
	private String yearOfConstruction;
	private TypeOfProperty typeOfProperty;
	private String vatNumber;
	private boolean isActive;

	public Property (String propertyID, String address, String yearOfConstruction, TypeOfProperty typeOfProperty,
			String vatNumber) {
		super();
		this.propertyID = propertyID;
		this.address = address;
		this.yearOfConstruction = yearOfConstruction;
		this.typeOfProperty = typeOfProperty;
		this.vatNumber = vatNumber;
		this.isActive = true;
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

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
