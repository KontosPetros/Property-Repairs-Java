package eu.dynamics.technikon.repository.impl;

import java.time.LocalDateTime;
import java.util.List;

import eu.dynamics.technikon.exception.PropertyRepairException;
import eu.dynamics.technikon.model.PropertyRepair;
import eu.dynamics.technikon.repository.PropertyRepairRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

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
				.setParameter("date", date)
				.getResultList();
		return resultList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PropertyRepair> readRangeOfDates(LocalDateTime dateFrom, LocalDateTime dateUntil) {
		List<PropertyRepair> resultList = super.getEntityManager()
				.createQuery("SELECT pr FROM PropertyRepair pr WHERE pr.scheduledDate BETWEEN :dateFrom and :dateUntil")
				.setParameter("dateFrom", dateFrom)
				.setParameter("dateUntil", dateUntil)
				.getResultList();
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
	public void updatePropertyRepair(Long id, String columnName, String newValue) {
		super.getEntityManager().getTransaction().begin();
		Query query = super.getEntityManager()
				.createQuery("UPDATE PropertyRepair p SET p." + columnName + " = :newValue WHERE p.id = :id")
				.setParameter("newValue", newValue)
				.setParameter("id", id);
		query.executeUpdate();
		super.getEntityManager().getTransaction().commit();
		
	}

	@Override
	public List<PropertyRepair> readVatNumber(String vatNumber) {
		return super.getEntityManager()
				.createQuery("SELECT p FROM PropertyRepair p JOIN p.propertyOwner WHERE p.propertyOwner.vatNumber = :value",
						getEntityClass())
				.setParameter("value", vatNumber).getResultList();

		
		
		
	}

}
