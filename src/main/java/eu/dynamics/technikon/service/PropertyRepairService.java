package eu.dynamics.technikon.service;

import java.time.LocalDateTime;
import java.util.List;

import eu.dynamics.technikon.exception.PropertyRepairException;
import eu.dynamics.technikon.model.PropertyRepair;

public interface PropertyRepairService {
	void addPropertyRepair(PropertyRepair propertyRepair) throws Exception;
	
	List<PropertyRepair> searchDate(LocalDateTime date) throws PropertyRepairException;
	List<PropertyRepair> searchRangeOfDates(LocalDateTime dateFrom, LocalDateTime dateUntil) throws PropertyRepairException;

	List<PropertyRepair> displayPropertyRepair();
	boolean deleteSafely(Long id) throws PropertyRepairException;
	public void updatePropertyRepair(Long id,String columnName, String newValue);
	

}
