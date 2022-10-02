package eu.dynamics.technikon.service.impl;

import java.util.List;
import java.util.Optional;

import eu.dynamics.technikon.exception.PropertyException;
import eu.dynamics.technikon.exception.PropertyOwnerException;
import eu.dynamics.technikon.model.PropertyOwner;
import eu.dynamics.technikon.repository.PropertyOwnerRepository;
import eu.dynamics.technikon.service.PropertyOwnerService;
import eu.dynamics.technikon.utility.GeneralUtility;

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

	@Override
	public PropertyOwner searchEmail(String email) throws PropertyOwnerException {
		PropertyOwner searchEmailResult = propertyOwnerRepository.readEmail(email);
		if (searchEmailResult == null) {
			throw new PropertyOwnerException("the property owner with email: " + email + "does not exists");
		}
		return searchEmailResult;
	}

	@Override
	public boolean updatePropertyOwner(Long propertyOwnerId, String email, String address, String password) throws PropertyOwnerException{
		Optional<PropertyOwner> propertyOwner = propertyOwnerRepository.read(propertyOwnerId);
		if (propertyOwner.isPresent()) {
			if (GeneralUtility.isValidEmail(email)){
				propertyOwner.get().setEmail(email);
			} else {
				throw new PropertyOwnerException("the email:" + email + " is not valid");
			}
			
			propertyOwner.get().setAddress(address);
			propertyOwner.get().setPassword(password);
			// nomizw thelei merge oxi persist h na kanoume kapoio create query
			propertyOwnerRepository.add(propertyOwner.get());
			
			return true;
		
		}
		return false;
	}

	

}
