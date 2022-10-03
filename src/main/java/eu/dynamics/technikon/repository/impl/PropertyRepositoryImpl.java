package eu.dynamics.technikon.repository.impl;

import java.util.List;

import eu.dynamics.technikon.model.Property;
import eu.dynamics.technikon.repository.PropertyRepository;
import jakarta.persistence.EntityManager;

public class PropertyRepositoryImpl extends RepositoryImpl<Property, Long> implements PropertyRepository {

	public PropertyRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public String getEntityClassName() {

		return Property.class.getName();
	}

	@Override
	public Class<Property> getEntityClass() {

		return Property.class;
	}

	@Override
	public List<Property> readVatNumber(String vatNumber) {
		return super.getEntityManager()
				.createQuery("SELECT p FROM Property p JOIN p.propertyOwner WHERE p.propertyOwner.vatNumber = :value",
						getEntityClass())
				.setParameter("value", vatNumber).getResultList();

	}

	@Override
	public Property readPropertyId(String propertyId) {
		return (Property) super.getEntityManager()
				.createNativeQuery("SELECT p FROM Property p Where p.propertyID = :value")
				.setParameter("value", propertyId).getSingleResult();
	}

	@Override
	public boolean deletePermanently(String propertyId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSafely(String propertyId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateProperty(Property property) {
		super.getEntityManager().getTransaction().begin();
		super.getEntityManager();
		super.getEntityManager().getTransaction().commit();
	}

}
