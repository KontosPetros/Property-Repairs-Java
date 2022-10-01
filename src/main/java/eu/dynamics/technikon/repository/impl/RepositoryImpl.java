package eu.dynamics.technikon.repository.impl;

import java.util.List;
import java.util.Optional;

import eu.dynamics.technikon.repository.Repository;
import jakarta.persistence.EntityManager;

public abstract class RepositoryImpl<T, K> implements Repository<T, K> {

	private EntityManager entityManager;

	public RepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public abstract String getEntityClassName();

	public abstract Class<T> getEntityClass();

	@Override
	public Optional<T> add(T t) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(t);
			entityManager.getTransaction().commit();
			return Optional.of(t);
		} catch (Exception e) {
			return Optional.empty();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> read(int pageNumber, int pageSize) {
		return entityManager.createQuery("from " + getEntityClassName()).getResultList();
	}

	@Override
	public Optional<T> read(K tId) {

		T t = entityManager.find(getEntityClass(), tId);
		if(t == null) {
			return Optional.empty();
		}
		return Optional.of(t);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
