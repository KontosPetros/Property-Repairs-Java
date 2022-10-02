package eu.dynamics.technikon.repository;

import eu.dynamics.technikon.model.PropertyOwner;
import jakarta.persistence.Query;

public interface PropertyOwnerRepository extends Repository<PropertyOwner, Long> {

	PropertyOwner readVatNumber(String vatNumber);

	PropertyOwner readEmail(String email);


	boolean deleteSafely(String vatNumber);

}
