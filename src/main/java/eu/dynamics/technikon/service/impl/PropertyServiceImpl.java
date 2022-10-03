package eu.dynamics.technikon.service.impl;

import java.util.List;
import java.util.Optional;

import eu.dynamics.technikon.exception.PropertyException;
import eu.dynamics.technikon.model.Property;
import eu.dynamics.technikon.repository.PropertyRepository;
import eu.dynamics.technikon.service.PropertyService;

public class PropertyServiceImpl implements PropertyService {

	private PropertyRepository propertyRepository;

	public PropertyServiceImpl(PropertyRepository propertyRepository) {
		this.propertyRepository = propertyRepository;
	}

	@Override
	public void addProperty(Property property) throws PropertyException {
		Optional<Property> dbproperty = propertyRepository.add(property);
		if (dbproperty.isEmpty()) {
			throw new PropertyException("The property has not been added ");
		}
	}

	@Override
	public List<Property> displayProperty() {
		return propertyRepository.read(1, 30);
	}

	@Override
	public Property searchPropertyId(String propertyId) {

		return propertyRepository.readPropertyId(propertyId);
	}

	@Override
	public List<Property> searchVatNumber(String vatNumber) {
		return propertyRepository.readVatNumber(vatNumber);
	}

	@Override
	public boolean deleteSafely(String propertyId) throws PropertyException {
		return propertyRepository.deleteSafely(propertyId);
	}

	@Override
	public boolean deletePermantly(String propertyId) throws PropertyException {
		return propertyRepository.deletePermantly(propertyId);
	}

	

}
