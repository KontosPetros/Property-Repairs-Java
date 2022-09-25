package eu.dynamics.technikon.repository;

import eu.dynamics.technikon.domain.Property;



public interface PropertyRepository extends Repository<Property>{
	
	Property readVatNumber(String vatNumber);
	Property readPropertyId(String propertyId);
	boolean deletePermanently(String propertyId);
	boolean deleteSafely(String propertyId);
	

}
