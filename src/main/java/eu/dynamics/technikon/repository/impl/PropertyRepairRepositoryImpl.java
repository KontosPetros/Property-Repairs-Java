package eu.dynamics.technikon.repository.impl;

import java.time.LocalDateTime;

import eu.dynamics.technikon.exception.PropertyException;
import eu.dynamics.technikon.exception.PropertyRepairException;
import eu.dynamics.technikon.model.Property;
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
	@Override
	public boolean deleteSafely(Long id) throws PropertyRepairException {
		PropertyRepair propertyRepairToDelete =  super.getEntityManager().find(getEntityClass(), id);
		if (propertyRepairToDelete == null) {
			throw new PropertyRepairException("the propertyRepair  with id " + id + " does not exists");
		}
		super.getEntityManager().getTransaction().begin();
		propertyRepairToDelete.setIsActive(0);
		super.getEntityManager().getTransaction().commit();

		return true;
		
	}

	

}
