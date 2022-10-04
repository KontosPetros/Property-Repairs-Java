package eu.dynamics.technikon.service.impl;

import java.util.List;
import java.util.Optional;

import eu.dynamics.technikon.exception.PropertyException;
import eu.dynamics.technikon.model.Property;
import eu.dynamics.technikon.repository.PropertyRepository;
import eu.dynamics.technikon.service.PropertyService;

public class PropertyServiceImpl implements PropertyService {

	private PropertyRepository propertyRepository;

	public PropertyServiceImpl(PropertyRepository propertyRepository) {
		this.propertyRepository = propertyRepository;
	}

	@Override
	public void addProperty(Property property) throws PropertyException {
		Optional<Property> dbproperty = propertyRepository.add(property);
		if (dbproperty.isEmpty()) {
			throw new PropertyException("The property has not been added ");
		}
	}

	@Override
	public List<Property> displayProperty() {
		return propertyRepository.read(1, 30);
	}

	
	@Override
	public Property searchPropertyId(String propertyId) throws PropertyException {
		Property searchPropertyIdResult = propertyRepository.readPropertyId(propertyId);
		   if (searchPropertyIdResult == null) {
			   throw new PropertyException("The property with propertyId: " + propertyId + " does not exist");
		   }
		   return searchPropertyIdResult;
          
		
	}

	@Override
	public List<Property> searchVatNumber(String vatNumber) throws PropertyException {
		List<Property> searchVatNumberResult = propertyRepository.readVatNumber(vatNumber);
		if (searchVatNumberResult == null) {
			throw new PropertyException("No properties for" + vatNumber + "exists");
		}
		return searchVatNumberResult;
	}

	@Override
	public boolean deleteSafely(String propertyId) throws PropertyException {
		boolean deleteSafelyResult = propertyRepository.deleteSafely(propertyId);
		  if (deleteSafelyResult == false) {
			  throw new PropertyException("Property has not safely deleted");
		  }
		return deleteSafelyResult;
	}

	@Override
	public boolean deletePermantly(String propertyId) throws PropertyException {
		boolean deletePermantlyResult = propertyRepository.deletePermantly(propertyId);
		if (deletePermantlyResult == false) {
			throw new PropertyException("Property has not permantly deleted");
		}
		return deletePermantlyResult;
	}

	@Override
	public void updateProperty(String propertyId, String columnName, String newValue)  {
		propertyRepository.updateProperty(propertyId, columnName, newValue);
		
		}
	
				
		
		
	

	

}
