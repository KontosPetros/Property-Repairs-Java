package eu.dynamics.technikon.repository.impl;

import eu.dynamics.technikon.domain.Property;
import eu.dynamics.technikon.repository.PropertyRepository;

public class PropertyRepositoryImpl extends RepositoryImpl<Property> implements PropertyRepository {

	public PropertyRepositoryImpl() {
		super();

	}

	@Override
	public Property readVatNumber(String vatNumber) {
		for (Property property : super.read()) {
			if (property.getVatNumber().equals(vatNumber))
				return property;
		}
		return null;
	}

	@Override
	public Property readPropertyId(String propertyId) {
		for (Property property : super.read()) {
			if (property.getPropertyID().equals(propertyId))
				return property;
		}
		return null;
	}

	@Override
	public boolean permanentlyDelete(String propertyId) {
		for(Property property : super.read()) {
			if (property.getPropertyID().equals(propertyId))
				super.read().remove(property);
				return true;
		}
		
		return false;
	}
	
	

}
