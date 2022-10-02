package eu.dynamics.technikon.repository;

import eu.dynamics.technikon.exception.PropertyOwnerException;
import eu.dynamics.technikon.model.PropertyOwner;

public interface PropertyOwnerRepository extends Repository<PropertyOwner, Long> {

	PropertyOwner readVatNumber(String vatNumber);

	PropertyOwner readEmail(String email);

	boolean deleteSafely(String vatNumber);
	boolean updatePropertyOwner(Long propertyOwnerId, String email, String address, String password) throws PropertyOwnerException;
}
