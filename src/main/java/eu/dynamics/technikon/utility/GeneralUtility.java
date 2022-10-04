package eu.dynamics.technikon.utility;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eu.dynamics.technikon.model.Property;
import eu.dynamics.technikon.model.PropertyOwner;

public class GeneralUtility {

	public static boolean isValidEmail(String email) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public static boolean isValidPropertyOwner(String vatNumber, String email, List<PropertyOwner> list) {

		if (!isValidEmail(email))
			return false;
		if (vatNumber == null)
			return false;

		for (PropertyOwner owner : list) {
			if (owner.getEmail().equals(email) || owner.getVatNumber().equals(vatNumber)) {
				return false;
			}
		}

		return true;
	}
     public static boolean isValidProperty (String propertyId, List<Property> list) {
    	 if(propertyId == null) return false;
    	 for (Property property : list) {
    		 if(property.getPropertyId().equals(propertyId)) {
    			 return false;
    		 }
    	 }
    	 return true; 
     }
     
}
