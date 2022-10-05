package eu.dynamics.technikon.service.impl;

import java.time.LocalDateTime;
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

	@Override
	public List<PropertyRepair> searchDate(LocalDateTime date) throws PropertyRepairException {
		List<PropertyRepair> propertyRepairSearch = propertyRepairRepository.readDate(date);
		if (propertyRepairSearch.isEmpty()) {
			throw new PropertyRepairException("No Repair  this Date");
		}
		return propertyRepairSearch;
	}

	@Override
	public List<PropertyRepair> searchRangeOfDates(LocalDateTime dateFrom, LocalDateTime dateUntil)
			throws PropertyRepairException {
		List<PropertyRepair> propertyRepairSearch = propertyRepairRepository.readRangeOfDates(dateFrom, dateUntil);
		if (propertyRepairSearch.isEmpty()) {
			throw new PropertyRepairException("No repair in this rangeOfDates");
		}
		return propertyRepairSearch;
	}

	@Override
	public boolean updatePropertyRepair(PropertyRepair propertyRepair) throws PropertyRepairException {
		boolean updatePropertyRepairResult = propertyRepairRepository.updatePropertyRepair(propertyRepair);
		if (updatePropertyRepairResult == false) {
			throw new PropertyRepairException("PropertyRepair has not updated");
		}
		return updatePropertyRepairResult;

	}

	@Override
	public List<PropertyRepair> searchVatNumber(String vatNumber) throws PropertyRepairException {
		List<PropertyRepair> propertyRepairSearch = propertyRepairRepository.readVatNumber(vatNumber);
		if (propertyRepairSearch.isEmpty()) {
			throw new PropertyRepairException("There are no repairs for this vatNumber");
		}
		return propertyRepairSearch;
	}

	@Override
	public PropertyRepair searchPropertyRepairId(Long id) throws PropertyRepairException {
		Optional<PropertyRepair> searchPropertyRepairId = propertyRepairRepository.read(id);
		if (searchPropertyRepairId.isEmpty()) {
			throw new PropertyRepairException("The propertyRepair does not exist");
		}
		return searchPropertyRepairId.get();
	}

}
