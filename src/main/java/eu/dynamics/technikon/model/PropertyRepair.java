package eu.dynamics.technikon.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class PropertyRepair {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime scheduledDate;
	private String description;
	private TypeOfRepair typeOfRepair;
	private StatusOfRepair statusOfRepair;
	private BigDecimal cost;
	private String workDescription;
	private String ownerID;

	@ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn(name = "propertyID", referencedColumnName = "propertyID")
	private Property property;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(LocalDateTime scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getWorkDescription() {
		return workDescription;
	}

	public void setWorkDescription(String workDescription) {
		this.workDescription = workDescription;
	}

	public String getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

}
