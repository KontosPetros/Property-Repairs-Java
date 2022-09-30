package eu.dynamics.technikon.repository.impl;

import eu.dynamics.technikon.model.Property;
import eu.dynamics.technikon.repository.PropertyRepository;
import jakarta.persistence.EntityManager;

public class PropertyRepositoryImpl extends RepositoryImpl<Property, Long> implements PropertyRepository {

	public PropertyRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public String getEntityClassName() {

		return Property.class.getName();
	}

	@Override
	public Class<Property> getEntityClass() {

		return Property.class;
	}

//	@Override
//	public Property readVatNumber(String vatNumber) {
//		for (Property property : super.read()) {
//			if (property.getVatNumber().equals(vatNumber))
//				return property;
//		}
//		return null;
//	}
//
//	@Override
//	public Property readPropertyId(String propertyId) {
//		for (Property property : super.read()) {
//			if (property.getPropertyID().equals(propertyId))
//				return property;
//		}
//		return null;
//	}
//
//	@Override
//	public boolean deletePermanently(String propertyId) {
//		for (Property property : super.read()) {
//			if (property.getPropertyID().equals(propertyId))
//				super.read().remove(property);
//			return true;
//		}
//
//		return false;
//	}
//
//	@Override
//	public boolean deleteSafely(String propertyId) {
//		Property property = readPropertyId(propertyId);
//		if (property == null)
//			return false;
//
//		property.setActive(false);
//		return true;
//	}

}
