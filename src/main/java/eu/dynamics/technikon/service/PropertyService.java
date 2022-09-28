package eu.dynamics.technikon.service;

import java.util.List;

import eu.dynamics.technikon.model.Property;

public interface PropertyService {
	void addProperty(Property property) throws Exception;
	List<Property> displayProperty();

}
