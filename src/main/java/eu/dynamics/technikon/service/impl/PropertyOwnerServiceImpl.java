package eu.dynamics.technikon.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import eu.dynamics.technikon.model.PropertyOwner;
import eu.dynamics.technikon.repository.PropertyOwnerRepository;
import eu.dynamics.technikon.repository.impl.PropertyOwnerRepositoryImpl;
import eu.dynamics.technikon.service.PropertyOwnerService;
import jakarta.persistence.EntityManager;


public class PropertyOwnerServiceImpl implements PropertyOwnerService {
	
private EntityManager entityManager;
	
	
	public PropertyOwnerServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public void addPropertyOwner(PropertyOwner propertyOwner) throws Exception  {
		// convention error
		// to be moved to the repository
		try {
			entityManager.getTransaction().begin();
            entityManager.persist(propertyOwner);
            entityManager.getTransaction().commit();
		}
		catch(Exception e) {
			throw new Exception();
		}
	}

	@Override
	public List<PropertyOwner> displayPropertyOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
