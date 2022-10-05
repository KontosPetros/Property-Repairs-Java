package eu.dynamics.technikon.repository;

import java.util.List;

import eu.dynamics.technikon.exception.PropertyException;
import eu.dynamics.technikon.model.Property;

public interface PropertyRepository extends Repository<Property, Long> {

	List<Property> readVatNumber(String vatNumber);

	Property readPropertyId(String propertyId);

	boolean updateProperty(Property property);

	boolean deletePermantly(Long propertyId) throws PropertyException;

	boolean deleteSafely(String propertyId) throws PropertyException;

}
