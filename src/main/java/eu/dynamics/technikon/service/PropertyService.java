package eu.dynamics.technikon.service;

import java.util.List;

import eu.dynamics.technikon.exception.PropertyException;
import eu.dynamics.technikon.exception.PropertyOwnerException;
import eu.dynamics.technikon.model.Property;

public interface PropertyService {
	void addProperty(Property property) throws PropertyException;
	List<Property> displayProperty();
	Property searchPropertyId(String propertyId) throws PropertyException;
	List<Property> searchVatNumber(String vatNumber) ;
    boolean deleteSafely (String propertyId) throws PropertyException;
    boolean deletePermantly (String propertyId) throws PropertyException;
}
