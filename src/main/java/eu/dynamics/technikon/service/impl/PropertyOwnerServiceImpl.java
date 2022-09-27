package eu.dynamics.technikon.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import eu.dynamics.technikon.domain.PropertyOwner;
import eu.dynamics.technikon.repository.PropertyOwnerRepository;
import eu.dynamics.technikon.repository.impl.PropertyOwnerRepositoryImpl;
import eu.dynamics.technikon.service.PropertyOwnerService;


public class PropertyOwnerServiceImpl implements PropertyOwnerService {

	private final PropertyOwnerRepository propertyOwnerRepository;
	private Connection connection;

	public PropertyOwnerServiceImpl(Connection connection) {
		this.connection = connection;
		propertyOwnerRepository = new PropertyOwnerRepositoryImpl();
	}

	@Override
	public void loadPropertyOwnerData() {
		
		

	}

	public void createTable() {
		String sql = "" + "create table if not exists property_owner (" + "vatNumber VARCHAR(20) not null ,"
				+ "name VARCHAR(20)," + "surName VARCHAR(20)," + "address VARCHAR(20)," + "phoneNumber VARCHAR(20),"
				+ "email VARCHAR(20)," + "username VARCHAR(20)," + "password VARCHAR(20)," + "primary key(vatNumber))";

		try (Statement statement = connection.createStatement()) {
			statement.executeUpdate(sql);
			System.out.println("-- Table property_owner created");
		} catch (SQLException e) {
			System.out.println("An error occured. Details: " + e.getMessage());
		}
	}

	@Override
	public void insertPropertyOwner(PropertyOwner propertyOwner) {
		String sql = "insert into property_owner  values" + "(?,?,?,?,?,?,?,?)";

		try (PreparedStatement prepareStatement = connection.prepareStatement(sql)) {

			prepareStatement.setString(1, propertyOwner.getVatNumber());
			prepareStatement.setString(2, propertyOwner.getName());
			prepareStatement.setString(3, propertyOwner.getSurname());
			prepareStatement.setString(4, propertyOwner.getAddress());
			prepareStatement.setString(5, propertyOwner.getPhoneNumber());
			prepareStatement.setString(6, propertyOwner.getEmail());
			prepareStatement.setString(7, propertyOwner.getUsername());
			prepareStatement.setString(8, propertyOwner.getPassword());
			prepareStatement.executeUpdate();
			System.out.println("-- Created: " + propertyOwner);
		} catch (SQLException e) {
			System.out.println("An error occured. Details: " + e.getMessage());
		}

	}

	@Override
	public List<PropertyOwner> findAll() {
		List<PropertyOwner> propertyOwners = new ArrayList<>();
		String sql = ""+
				"select * from property_owner";

		try (Statement statement = connection.createStatement()) {
			ResultSet resultSet = statement.executeQuery(sql);
			System.out.println("-- Retrieving all property owners");
			while (resultSet.next()) {
				PropertyOwner propertyOwner = new PropertyOwner();
				propertyOwner.setVatNumber(resultSet.getString("vatNumber"));
				propertyOwner.setName(resultSet.getString("name"));
				propertyOwner.setSurname(resultSet.getString("surname"));
				propertyOwner.setAddress(resultSet.getString("address"));
				propertyOwner.setPhoneNumber(resultSet.getString("phoneNumber"));
				propertyOwner.setAddress(resultSet.getString("address"));
				propertyOwner.setUsername(resultSet.getString("username"));
				propertyOwner.setPassword(resultSet.getString("password"));
				propertyOwners.add(propertyOwner);
			}
		} catch (SQLException e) {
			System.out.println("An error occured. Details: " + e.getMessage());
		}
		return propertyOwners;
	}

}
