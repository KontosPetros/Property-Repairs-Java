package eu.dynamics.technikon.service.impl;

import java.util.List;

import eu.dynamics.technikon.model.Property;
import eu.dynamics.technikon.service.PropertyService;
import jakarta.persistence.EntityManager;

public class PropertyServiceImpl implements PropertyService{
	
	
	private EntityManager entityManager;
	
	

	public PropertyServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void addProperty(Property property) throws Exception {
		try {
			entityManager.getTransaction().begin();
            entityManager.persist(property);
            entityManager.getTransaction().commit();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
		
	}

	@Override
	public List<Property> displayProperty() {
		// TODO Auto-generated method stub
		return null;
	}

}
