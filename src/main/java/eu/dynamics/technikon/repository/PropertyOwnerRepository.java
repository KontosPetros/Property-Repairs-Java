package eu.dynamics.technikon.repository;

import eu.dynamics.technikon.domain.PropertyOwner;

public interface PropertyOwnerRepository extends Repository<PropertyOwner>{
	
	PropertyOwner readVatNumber(String vatNumber);
	PropertyOwner readEmail(String email);
	
	boolean updateEmail(String vatNumber, String email);
	boolean updateAddress(String vatNumber, String address);
	boolean updatePassword(String vatNumber, String password);
	
	

}
