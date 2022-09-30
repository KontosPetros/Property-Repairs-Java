package eu.dynamics.technikon.service;

import java.util.List;

import eu.dynamics.technikon.model.PropertyOwner;

public interface PropertyOwnerService {

	void addPropertyOwner(PropertyOwner propertyOwner) throws Exception;

	List<PropertyOwner> displayPropertyOwner();

	// void loadPropertyOwnerData();
	// void createTable();
	// void insertPropertyOwner(PropertyOwner propertyOwner);
	// List<PropertyOwner> findAll();
}
