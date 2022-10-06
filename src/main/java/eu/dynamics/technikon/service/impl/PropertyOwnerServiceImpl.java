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
	public void loadPropertyOwnerData(List<String> propertyOwnerList) throws PropertyOwnerException {
		for (String propertyOwnerData : propertyOwnerList) {

			String splitData[] = propertyOwnerData.strip().split(",");

			PropertyOwner propertyOwner = new PropertyOwner();
			propertyOwner.setVatNumber(splitData[0]);
			propertyOwner.setName(splitData[1]);
			propertyOwner.setSurname(splitData[2]);
			propertyOwner.setAddress(splitData[3]);
			propertyOwner.setPhoneNumber(splitData[4]);
			propertyOwner.setEmail(splitData[5]);
			propertyOwner.setUsername(splitData[6]);
			propertyOwner.setPassword(splitData[7]);

			addPropertyOwner(propertyOwner);

		}

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
		if (result == null) {
			throw new PropertyOwnerException("the property owner with vatVumber: " + vatNumber + " does not exists");
		}
		return result;
	}

	@Override
	public PropertyOwner searchEmail(String email) throws PropertyOwnerException {
		PropertyOwner searchEmailResult = propertyOwnerRepository.readEmail(email);
		if (searchEmailResult == null) {
			throw new PropertyOwnerException("the property owner with email: " + email + "does not exists");
		}
		return searchEmailResult;
	}

	@Override

	public boolean updatePropertyOwner(Long propertyOwnerId, String email, String address, String password)
			throws PropertyOwnerException {
		return propertyOwnerRepository.updatePropertyOwner(propertyOwnerId, email, address, password);
	}

	@Override
	public boolean deleteSafely(String vatNumber) throws PropertyOwnerException {

		return propertyOwnerRepository.deleteSafely(vatNumber);
	}

	@Override
	public PropertyOwner findOwnerById(Long id) throws PropertyOwnerException {
		Optional<PropertyOwner> dbPropertyOwner = propertyOwnerRepository.read(id);
		if (dbPropertyOwner.isEmpty()) {
			throw new PropertyOwnerException("the property owner has not been found");
		}
		return dbPropertyOwner.get();
	}

}
