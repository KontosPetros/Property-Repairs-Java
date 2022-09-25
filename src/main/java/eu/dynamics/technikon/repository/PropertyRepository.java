package eu.dynamics.technikon.repository;

import eu.dynamics.technikon.domain.Property;
import eu.dynamics.technikon.domain.PropertyOwner;


public interface PropertyRepository extends Repository<Property>{
	
	Property readVatNumber(String vatNumber);
	Property readPropertyId(String propertyId);
	boolean permanentlyDelete(String propertyId);
	

}
