package eu.dynamics.technikon.service;

import java.util.List;

import eu.dynamics.technikon.domain.PropertyOwner;

public interface PropertyOwnerService {
	void loadPropertyOwnerData();
	void createTable();
	void insertPropertyOwner(PropertyOwner propertyOwner);
	List<PropertyOwner> findAll();
}
