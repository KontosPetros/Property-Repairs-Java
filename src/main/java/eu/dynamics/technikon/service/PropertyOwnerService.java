package eu.dynamics.technikon.service;

import java.util.List;

import eu.dynamics.technikon.exception.PropertyOwnerException;
import eu.dynamics.technikon.model.PropertyOwner;

public interface PropertyOwnerService {

	void loadPropertyOwnerData(List<String> propertyOwnerList) throws PropertyOwnerException;

	void addPropertyOwner(PropertyOwner propertyOwner) throws PropertyOwnerException;

	PropertyOwner findOwnerById(Long id) throws PropertyOwnerException;

	PropertyOwner searchVatNumber(String vatNumber) throws PropertyOwnerException;

	PropertyOwner searchEmail(String email) throws PropertyOwnerException;

	List<PropertyOwner> displayPropertyOwner();

	boolean updatePropertyOwner(Long propertyOwnerId, String email, String address, String password)
			throws PropertyOwnerException;

	boolean deleteSafely(String vatNumber) throws PropertyOwnerException;
}
