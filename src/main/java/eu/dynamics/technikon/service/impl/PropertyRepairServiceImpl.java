package eu.dynamics.technikon.service.impl;

import java.util.List;
import java.util.Optional;

import eu.dynamics.technikon.model.PropertyRepair;
import eu.dynamics.technikon.repository.Repository;
import eu.dynamics.technikon.service.PropertyRepairService;

public class PropertyRepairServiceImpl implements PropertyRepairService {
	private Repository<PropertyRepair, Long> propertyRepairRepository;

	public PropertyRepairServiceImpl(Repository<PropertyRepair, Long> propertyRepairRepository) {
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

}
