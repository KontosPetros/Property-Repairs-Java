package eu.dynamics.technikon.repository.impl;

import java.time.LocalDateTime;
import java.util.List;

import eu.dynamics.technikon.exception.PropertyRepairException;
import eu.dynamics.technikon.model.PropertyRepair;
import eu.dynamics.technikon.repository.PropertyRepairRepository;
import jakarta.persistence.EntityManager;

public class PropertyRepairRepositoryImpl extends RepositoryImpl<PropertyRepair, Long>
		implements PropertyRepairRepository {

	public PropertyRepairRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public String getEntityClassName() {

		return PropertyRepair.class.getName();
	}

	@Override
	public Class<PropertyRepair> getEntityClass() {

		return PropertyRepair.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PropertyRepair> readDate(LocalDateTime date) {
		List<PropertyRepair> resultList = super.getEntityManager()
				.createQuery("SELECT pr FROM PropertyRepair pr WHERE pr.scheduledDate= :date")
				.setParameter("date", date).getResultList();
		return resultList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PropertyRepair> readRangeOfDates(LocalDateTime dateFrom, LocalDateTime dateUntil) {
		List<PropertyRepair> resultList = super.getEntityManager()
				.createQuery("SELECT pr FROM PropertyRepair pr WHERE pr.scheduledDate BETWEEN :dateFrom and :dateUntil")
				.setParameter("dateFrom", dateFrom).setParameter("dateUntil", dateUntil).getResultList();
		return resultList;
	}

	@Override
	public boolean deleteSafely(Long id) throws PropertyRepairException {
		PropertyRepair propertyRepairToDelete = super.getEntityManager().find(getEntityClass(), id);
		if (propertyRepairToDelete == null) {
			throw new PropertyRepairException("the propertyRepair  with id " + id + " does not exists");
		}
		super.getEntityManager().getTransaction().begin();
		propertyRepairToDelete.setIsActive(0);
		super.getEntityManager().getTransaction().commit();

		return true;

	}

	@Override
	public boolean updatePropertyRepair(PropertyRepair propertyRepair) {
		PropertyRepair persistentInstance = super.getEntityManager().find(getEntityClass(), propertyRepair.getId());
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

	@Override
	public List<PropertyRepair> readVatNumber(String vatNumber) {
		return super.getEntityManager().createQuery(
				"SELECT p FROM PropertyRepair p JOIN p.propertyOwner WHERE p.propertyOwner.vatNumber = :value",
				getEntityClass()).setParameter("value", vatNumber).getResultList();

	}

}
