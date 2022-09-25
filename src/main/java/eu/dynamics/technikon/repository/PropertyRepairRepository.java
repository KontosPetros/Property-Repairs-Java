package eu.dynamics.technikon.repository;

import java.time.LocalDateTime;

import eu.dynamics.technikon.domain.PropertyRepair;

public interface PropertyRepairRepository extends Repository<PropertyRepair>{
	
       PropertyRepair readDate(LocalDateTime date);
       PropertyRepair readRangeOfDates(LocalDateTime dateFrom, LocalDateTime dateUntil);
       
}
