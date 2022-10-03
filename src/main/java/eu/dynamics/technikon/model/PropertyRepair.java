package eu.dynamics.technikon.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Where;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Where(clause = "isActive = 1")
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
	
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "vatNumber",
            referencedColumnName = "vatNumber"
        )
	private PropertyOwner propertyOwner;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "propertyID", referencedColumnName = "propertyID")
	private Property property;
	
	private Integer isActive = 1;

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

	public PropertyOwner getOwner() {
		return propertyOwner;
	}

	public void setOwner(PropertyOwner propertyOwner) {
		this.propertyOwner = propertyOwner;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

}
