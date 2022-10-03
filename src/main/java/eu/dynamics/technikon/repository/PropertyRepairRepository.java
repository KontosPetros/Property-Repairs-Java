package eu.dynamics.technikon.repository;

import java.time.LocalDateTime;

import eu.dynamics.technikon.exception.PropertyRepairException;
import eu.dynamics.technikon.model.PropertyRepair;

public interface PropertyRepairRepository extends Repository<PropertyRepair, Long>{
	
//       PropertyRepair readDate(LocalDateTime date);
//       PropertyRepair readRangeOfDates(LocalDateTime dateFrom, LocalDateTime dateUntil);
	
		boolean deleteSafely(Long id) throws PropertyRepairException;
       
}
