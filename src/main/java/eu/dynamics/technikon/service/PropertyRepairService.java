package eu.dynamics.technikon.service;

import java.util.List;

import eu.dynamics.technikon.exception.PropertyRepairException;
import eu.dynamics.technikon.model.PropertyRepair;

public interface PropertyRepairService {
	void addPropertyRepair(PropertyRepair propertyRepair) throws Exception;

	List<PropertyRepair> displayPropertyRepair();
	boolean deleteSafely(Long id) throws PropertyRepairException;

}
