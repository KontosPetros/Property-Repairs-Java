package eu.dynamics.technikon.repository.impl;

import java.time.LocalDateTime;


import eu.dynamics.technikon.model.PropertyRepair;
import eu.dynamics.technikon.repository.PropertyRepairRepository;
import jakarta.persistence.EntityManager;

public class PropertyRepairRepositoryImpl extends RepositoryImpl<PropertyRepair, Long> implements PropertyRepairRepository {

	public PropertyRepairRepositoryImpl(EntityManager entityManager) {
		super(entityManager);

	}
//	@Override
//	public PropertyRepair readDate(LocalDateTime date) {
//		for (PropertyRepair propertyRepair : super.read()) {
//			if (propertyRepair.getDate().equals(date))
//				return propertyRepair;
//		}
//		
//		return null;
//	}
//	@Override
//	public PropertyRepair readRangeOfDates(LocalDateTime dateFrom, LocalDateTime dateUntil) {
//		for (PropertyRepair propertyRepair : super.read()) {
//			if (propertyRepair.getDate().isBefore(dateUntil) && propertyRepair.getDate().isAfter(dateFrom))
//				return propertyRepair;
//			
//		}
//		return null;
//	}

	@Override
	public String getEntityClassName() {
	
		return PropertyRepair.class.getName();
	}

	@Override
	public Class<PropertyRepair> getEntityClass() {
		
		return PropertyRepair.class;
	}

}
