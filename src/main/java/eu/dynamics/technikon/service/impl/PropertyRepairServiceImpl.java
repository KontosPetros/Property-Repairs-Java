package eu.dynamics.technikon.service.impl;

import java.util.List;
import java.util.Optional;

import eu.dynamics.technikon.exception.PropertyRepairException;
import eu.dynamics.technikon.model.PropertyRepair;
import eu.dynamics.technikon.repository.PropertyRepairRepository;
import eu.dynamics.technikon.service.PropertyRepairService;

public class PropertyRepairServiceImpl implements PropertyRepairService {
	private PropertyRepairRepository propertyRepairRepository;

	public PropertyRepairServiceImpl(PropertyRepairRepository propertyRepairRepository) {
		this.propertyRepairRepository = propertyRepairRepository;
	}

	@Override
	public void addPropertyRepair(PropertyRepair propertyRepair) throws Exception {
		Optional<PropertyRepair> dbPropertyRepair = propertyRepairRepository.add(propertyRepair);
		if (dbPropertyRepair.isEmpty()) {
			throw new Exception();

		}
	}

	@Override
	public List<PropertyRepair> displayPropertyRepair() {

		return propertyRepairRepository.read(1, 20);
	}

	@Override
	public boolean deleteSafely(Long id) throws PropertyRepairException {
		return propertyRepairRepository.deleteSafely(id);
		
		
	}

}
