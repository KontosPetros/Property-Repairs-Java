package eu.dynamics.technikon.repository.impl;

import java.time.LocalDateTime;


import eu.dynamics.technikon.model.PropertyRepair;
import eu.dynamics.technikon.repository.PropertyRepairRepository;

public class PropertyRepairRepositoryImpl extends RepositoryImpl<PropertyRepair> implements PropertyRepairRepository {

	public PropertyRepairRepositoryImpl() {
		super();

	}
	@Override
	public PropertyRepair readDate(LocalDateTime date) {
		for (PropertyRepair propertyRepair : super.read()) {
			if (propertyRepair.getDate().equals(date))
				return propertyRepair;
		}
		
		return null;
	}
	@Override
	public PropertyRepair readRangeOfDates(LocalDateTime dateFrom, LocalDateTime dateUntil) {
		for (PropertyRepair propertyRepair : super.read()) {
			if (propertyRepair.getDate().isBefore(dateUntil) && propertyRepair.getDate().isAfter(dateFrom))
				return propertyRepair;
			
		}
		return null;
	}

}
