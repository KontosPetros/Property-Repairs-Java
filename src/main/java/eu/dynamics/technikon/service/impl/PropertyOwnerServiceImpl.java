package eu.dynamics.technikon.service.impl;

import java.util.List;
import java.util.Optional;

import eu.dynamics.technikon.model.PropertyOwner;
import eu.dynamics.technikon.repository.Repository;
import eu.dynamics.technikon.service.PropertyOwnerService;

public class PropertyOwnerServiceImpl implements PropertyOwnerService {
	private Repository<PropertyOwner, Long> propertyOwnerRepository;

	public PropertyOwnerServiceImpl(Repository<PropertyOwner, Long> propertyOwnerRepository) {
		this.propertyOwnerRepository = propertyOwnerRepository;
	}

	@Override
	public void addPropertyOwner(PropertyOwner propertyOwner) throws Exception {
		Optional<PropertyOwner> dbPropertyOwner = propertyOwnerRepository.add(propertyOwner);
		if (dbPropertyOwner.isEmpty()) {
			throw new Exception();
		}

	}

	@Override
	public List<PropertyOwner> displayPropertyOwner() {

		return propertyOwnerRepository.read(1, 20);
	}

}
