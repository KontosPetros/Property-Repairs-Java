package eu.dynamics.technikon.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import eu.dynamics.technikon.exception.PropertyException;
import eu.dynamics.technikon.exception.PropertyRepairException;
import eu.dynamics.technikon.model.PropertyRepair;
import eu.dynamics.technikon.model.StatusOfRepair;
import eu.dynamics.technikon.model.TypeOfRepair;
import eu.dynamics.technikon.repository.PropertyRepairRepository;
import eu.dynamics.technikon.service.PropertyOwnerService;
import eu.dynamics.technikon.service.PropertyRepairService;
import eu.dynamics.technikon.service.PropertyService;

public class PropertyRepairServiceImpl implements PropertyRepairService {
	private PropertyRepairRepository propertyRepairRepository;

	public PropertyRepairServiceImpl(PropertyRepairRepository propertyRepairRepository) {
		this.propertyRepairRepository = propertyRepairRepository;
	}

	@Override
	public void loadPropertyRepairData(List<String> propertyRepairList, PropertyOwnerService propertyOwnerService,
			PropertyService propertyService) throws Exception {

		for (String propertyRepairData : propertyRepairList) {
			String splitData[] = propertyRepairData.strip().split(",");
			PropertyRepair propertyRepair = new PropertyRepair();
			propertyRepair.setScheduledDate(LocalDateTime.parse(splitData[0]));
			propertyRepair.setDescription(splitData[1]);
			propertyRepair.setTypeOfRepair(TypeOfRepair.valueOf(splitData[2]));
			propertyRepair.setStatusOfRepair(StatusOfRepair.valueOf(splitData[3]));
			propertyRepair.setCost(BigDecimal.valueOf(Double.parseDouble(splitData[4])));

			try {

				propertyRepair.setProperty(propertyService.findPropertyById(Long.parseLong(splitData[6])));
				propertyRepair
						.setOwner(propertyService.findPropertyById(Long.parseLong(splitData[6])).getPropertyOwner());

			} catch (PropertyException e) {
				e.printStackTrace();
			}

			propertyRepair.setWorkDescription(splitData[7]);

			addPropertyRepair(propertyRepair);

		}

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
