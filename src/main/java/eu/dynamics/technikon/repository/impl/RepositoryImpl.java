package eu.dynamics.technikon.repository.impl;

import java.util.ArrayList;
import java.util.List;

import eu.dynamics.technikon.domain.Entity;
import eu.dynamics.technikon.repository.Repository;

public class RepositoryImpl<T extends Entity> implements Repository<T> {

	private final List<T> list;

	public RepositoryImpl() {
		this.list = new ArrayList<>();
	}

	@Override
	public boolean add(T t) {
		list.add(t);
		return true;
	}

	@Override
	public List<T> read() {
		return list;
	}

	

}
