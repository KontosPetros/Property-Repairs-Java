package eu.dynamics.technikon.service;

import java.time.LocalDateTime;
import java.util.List;

import eu.dynamics.technikon.exception.PropertyRepairException;
import eu.dynamics.technikon.model.PropertyRepair;

public interface PropertyRepairService {
	void addPropertyRepair(PropertyRepair propertyRepair) throws Exception;

	List<PropertyRepair> searchDate(LocalDateTime date) throws PropertyRepairException;

	List<PropertyRepair> searchRangeOfDates(LocalDateTime dateFrom, LocalDateTime dateUntil)
			throws PropertyRepairException;

	PropertyRepair searchPropertyRepairId(Long id) throws PropertyRepairException;

	List<PropertyRepair> displayPropertyRepair();

	List<PropertyRepair> searchVatNumber(String vatNumber) throws PropertyRepairException;

	boolean deleteSafely(Long id) throws PropertyRepairException;

	boolean updatePropertyRepair(PropertyRepair propertyRepair) throws PropertyRepairException;

	void loadPropertyRepairData(List<String> propertyRepairList, PropertyOwnerService propertyOwnerService,
			PropertyService propertyService) throws Exception;

}
