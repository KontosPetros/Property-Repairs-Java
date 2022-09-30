package eu.dynamics.technikon.repository.impl;

import eu.dynamics.technikon.model.PropertyOwner;
import eu.dynamics.technikon.repository.PropertyOwnerRepository;
import jakarta.persistence.EntityManager;

public class PropertyOwnerRepositoryImpl extends RepositoryImpl<PropertyOwner,Long> implements PropertyOwnerRepository {

	public PropertyOwnerRepositoryImpl(EntityManager entityManager) {
		super(entityManager);

	}

//	
//	@Override
//	public PropertyOwner readVatNumber(String vatNumber) {
//		for (PropertyOwner propertyOwner : super.read()) {
//			if (propertyOwner.getVatNumber().equals(vatNumber))
//				return propertyOwner;
//		}
//		return null;
//	}
//
//	@Override
//	public PropertyOwner readEmail(String email) {
//		for (PropertyOwner propertyOwner : super.read()) {
//			if (propertyOwner.getEmail().equals(email)) {
//				return propertyOwner;
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public boolean updateEmail(String vatNumber, String email) {
//		PropertyOwner propertyOwner = readVatNumber(vatNumber);
//		if (propertyOwner == null)
//			return false;
//
//		propertyOwner.setEmail(email);
//
//		return true;
//	}
//
//	@Override
//	public boolean updateAddress(String vatNumber, String address) {
//		PropertyOwner propertyOwner = readVatNumber(vatNumber);
//		if (propertyOwner == null)
//			return false;
//
//		propertyOwner.setAddress(address);
//
//		return true;
//	}
//
//	@Override
//	public boolean updatePassword(String vatNumber, String password) {
//		PropertyOwner propertyOwner = readVatNumber(vatNumber);
//		if (propertyOwner == null)
//			return false;
//
//		propertyOwner.setPassword(password);
//
//		return true;
//	}
//
//
////	@Override
////	public boolean deleteSafely(String vatNumber) {
////		PropertyOwner propertyOwner = readVatNumber(vatNumber);
////		if (propertyOwner == null)
////			return false;
////		
////		propertyOwner.setActive(false);
////		return true;
////	}


	@Override
	public String getEntityClassName() {
		return PropertyOwner.class.getName();
	}


	@Override
	public Class<PropertyOwner> getEntityClass() {
		
		return PropertyOwner.class;
	}

	
	
	

}
