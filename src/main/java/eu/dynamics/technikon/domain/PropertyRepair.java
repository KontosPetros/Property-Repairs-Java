package eu.dynamics.technikon.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PropertyRepair implements Entity {

	private LocalDateTime date;
	private String descriptionOfRepair;
	private TypeOfRepair typeOfRepair;
	private StatusOfRepair statusOfRepair;
	private BigDecimal costOfRepair;
	private String ownerId;
	private String description;
	private String propertyID;

	public PropertyRepair(LocalDateTime date, String descriptionOfRepair, TypeOfRepair typeOfRepair,
			StatusOfRepair statusOfRepair, BigDecimal costOfRepair, String ownerId, String description,String propertyID) {
		super();
		this.date = date;
		this.descriptionOfRepair = descriptionOfRepair;
		this.typeOfRepair = typeOfRepair;
		this.statusOfRepair = statusOfRepair;
		this.costOfRepair = costOfRepair;
		this.ownerId = ownerId;
		this.description = description;
		this.propertyID = propertyID;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void LocalDate(LocalDateTime date) {
		this.date = date;
	}

	public String getDescriptionOfRepair() {
		return descriptionOfRepair;
	}

	public void setDescriptionOfRepair(String descriptionOfRepair) {
		this.descriptionOfRepair = descriptionOfRepair;
	}

	public TypeOfRepair getTypeOfRepair() {
		return typeOfRepair;
	}

	public void setTypeOfRepair(TypeOfRepair typeOfRepair) {
		this.typeOfRepair = typeOfRepair;
	}

	public StatusOfRepair getStatusOfRepair() {
		return statusOfRepair;
	}

	public void setStatusOfRepair(StatusOfRepair statusOfRepair) {
		this.statusOfRepair = statusOfRepair;
	}

	public BigDecimal getCostOfRepair() {
		return costOfRepair;
	}

	public void setCostOfRepair(BigDecimal costOfRepair) {
		this.costOfRepair = costOfRepair;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	@Override
	public String toString() {
		return "PropertyRepair [date=" + date + ", descriptionOfRepair=" + descriptionOfRepair + ", typeOfRepair="
				+ typeOfRepair + ", statusOfRepair=" + statusOfRepair + ", costOfRepair=" + costOfRepair + ", ownerId="
				+ ownerId + ", description=" + description + ", propertyID=" + propertyID + "]";
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getPropertyID() {
		return propertyID;
	}

	public void setPropertyID(String propertyID) {
		this.propertyID = propertyID;
	}

}
