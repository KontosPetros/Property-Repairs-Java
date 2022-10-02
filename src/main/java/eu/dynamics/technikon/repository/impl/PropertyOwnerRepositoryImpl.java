package eu.dynamics.technikon.repository.impl;

import java.util.Optional;

import eu.dynamics.technikon.exception.PropertyOwnerException;
import eu.dynamics.technikon.model.PropertyOwner;
import eu.dynamics.technikon.repository.PropertyOwnerRepository;
import eu.dynamics.technikon.utility.GeneralUtility;
import jakarta.persistence.EntityManager;

public class PropertyOwnerRepositoryImpl extends RepositoryImpl<PropertyOwner, Long>
		implements PropertyOwnerRepository {

	public PropertyOwnerRepositoryImpl(EntityManager entityManager) {
		super(entityManager);

	}

	@Override
	public PropertyOwner readVatNumber(String vatNumber) {

		return (PropertyOwner) super.getEntityManager()
				.createQuery("SELECT p FROM PropertyOwner p WHERE p.vatNumber = :value")
				.setParameter("value", vatNumber).getSingleResult();
	}

	@Override
	public PropertyOwner readEmail(String email) {

		return (PropertyOwner) super.getEntityManager()
				.createQuery("SELECT c FROM PropertyOwner c Where c.email = :value")
				.setParameter("value", email).getSingleResult();
	}

	

//	@Override
//	public boolean deleteSafely(String vatNumber) {
//		PropertyOwner propertyOwner = readVatNumber(vatNumber);
//		if (propertyOwner == null)
//			return false;
//		
//		propertyOwner.setActive(false);
//		return true;
//	}

	@Override
	public String getEntityClassName() {
		return PropertyOwner.class.getName();
	}

	@Override
	public Class<PropertyOwner> getEntityClass() {

		return PropertyOwner.class;
	}

	@Override
	public boolean deleteSafely(String vatNumber) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean updatePropertyOwner(Long propertyOwnerId, String email, String address, String password) throws PropertyOwnerException{
		Optional<PropertyOwner> propertyOwner = super.read(propertyOwnerId);
		if (propertyOwner.isPresent()) {
			if (GeneralUtility.isValidEmail(email)){
				propertyOwner.get().setEmail(email);
			} else {
				throw new PropertyOwnerException("the email:" + email + " is not valid");
			}
			
			propertyOwner.get().setAddress(address);
			propertyOwner.get().setPassword(password);
			super.add(propertyOwner.get());
			
			return true;
		
		}
		return false;
	}

}
