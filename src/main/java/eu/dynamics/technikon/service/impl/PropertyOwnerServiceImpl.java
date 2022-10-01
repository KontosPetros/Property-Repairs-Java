package eu.dynamics.technikon.service.impl;

import java.util.List;
import java.util.Optional;

import eu.dynamics.technikon.exception.PropertyOwnerException;
import eu.dynamics.technikon.model.PropertyOwner;
import eu.dynamics.technikon.repository.PropertyOwnerRepository;
import eu.dynamics.technikon.service.PropertyOwnerService;

public class PropertyOwnerServiceImpl implements PropertyOwnerService {
	private PropertyOwnerRepository propertyOwnerRepository;

	public PropertyOwnerServiceImpl(PropertyOwnerRepository propertyOwnerRepository) {
		this.propertyOwnerRepository = propertyOwnerRepository;
	}

	@Override
	public void addPropertyOwner(PropertyOwner propertyOwner) throws PropertyOwnerException {
		Optional<PropertyOwner> dbPropertyOwner = propertyOwnerRepository.add(propertyOwner);
		if (dbPropertyOwner.isEmpty()) {
			throw new PropertyOwnerException("the property owner has not been added");
		}

	}

	@Override
	public List<PropertyOwner> displayPropertyOwner() {

		return propertyOwnerRepository.read(1, 20);
	}

	@Override
	public PropertyOwner searchVatNumber(String vatNumber) throws PropertyOwnerException {
		PropertyOwner result = propertyOwnerRepository.readVatNumber(vatNumber);
		if (result==null) {
			throw new PropertyOwnerException("the property owner with vatVumber: " + vatNumber + " does not exists");
		}
		return result;
	}

}
