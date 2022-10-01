package eu.dynamics.technikon.service.impl;

import java.util.List;
import java.util.Optional;

import eu.dynamics.technikon.exception.PropertyException;
import eu.dynamics.technikon.model.Property;
import eu.dynamics.technikon.repository.Repository;
import eu.dynamics.technikon.service.PropertyService;

public class PropertyServiceImpl implements PropertyService {

	private Repository<Property, Long> propertyRepository;

	public PropertyServiceImpl(Repository<Property, Long> propertyRepository) {
		this.propertyRepository = propertyRepository;
	}

	@Override
	public void addProperty(Property property) throws PropertyException {
		Optional<Property> dbproperty = propertyRepository.add(property);
		if (dbproperty.isEmpty()) {
			throw new PropertyException("The property has not been added");
		}
	}

	@Override
	public List<Property> displayProperty() {
		return propertyRepository.read(1, 30);
	}

}
