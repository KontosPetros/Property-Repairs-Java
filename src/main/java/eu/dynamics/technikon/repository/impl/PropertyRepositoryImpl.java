package eu.dynamics.technikon.repository.impl;

import java.util.List;

import eu.dynamics.technikon.exception.PropertyException;
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
		return (Property) super.getEntityManager().createQuery("SELECT p FROM Property p WHERE p.propertyId = :value")
				.setParameter("value", propertyId).getSingleResult();
	}

	@Override
	public boolean deletePermantly(Long propertyId) throws PropertyException {
		Property persistentInstance = super.getEntityManager().find(getEntityClass(), propertyId);
		if (persistentInstance != null) {

			try {

				super.getEntityManager().getTransaction().begin();
				super.getEntityManager().remove(persistentInstance);
				super.getEntityManager().getTransaction().commit();
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		return false;

	}

	@Override
	public boolean deleteSafely(String propertyId) throws PropertyException {

		Property propertyToDelete = readPropertyId(propertyId);
		if (propertyToDelete == null) {
			throw new PropertyException("the property  with propertyId " + propertyId + " does not exists");
		}
		super.getEntityManager().getTransaction().begin();
		propertyToDelete.setIsActive(0);
		super.getEntityManager().getTransaction().commit();

		return true;
	}

	@Override
	public boolean updateProperty(Property property) {

		Property persistentInstance = super.getEntityManager().find(getEntityClass(), property.getId());
		if (persistentInstance != null) {

			try {

				super.getEntityManager().getTransaction().begin();
				super.getEntityManager().merge(persistentInstance);
				super.getEntityManager().getTransaction().commit();
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		return false;
	}
}
