package eu.dynamics.technikon.repository;

import java.time.LocalDateTime;
import java.util.List;

import eu.dynamics.technikon.exception.PropertyRepairException;
import eu.dynamics.technikon.model.PropertyRepair;

public interface PropertyRepairRepository extends Repository<PropertyRepair, Long> {

	List<PropertyRepair> readDate(LocalDateTime date);

	List<PropertyRepair> readRangeOfDates(LocalDateTime dateFrom, LocalDateTime dateUntil);

	List<PropertyRepair> readVatNumber(String vatNumber);

	boolean deleteSafely(Long id) throws PropertyRepairException;

	boolean updatePropertyRepair(PropertyRepair propertyRepair);

}
