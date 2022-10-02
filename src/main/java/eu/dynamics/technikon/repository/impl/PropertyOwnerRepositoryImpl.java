package eu.dynamics.technikon.repository.impl;

import eu.dynamics.technikon.model.PropertyOwner;
import eu.dynamics.technikon.repository.PropertyOwnerRepository;
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

}
