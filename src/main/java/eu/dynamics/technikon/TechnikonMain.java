package eu.dynamics.technikon;

import eu.dynamics.technikon.domain.PropertyOwner;
import eu.dynamics.technikon.repository.PropertyOwnerRepository;
import eu.dynamics.technikon.repository.impl.PropertyOwnerRepositoryImpl;

public class TechnikonMain {
	
	public static void main(String[] args) {
		
		
		PropertyOwner test = new PropertyOwner("4198274", "petros", " kontos", " ioannina", " 123", "email","pe", "123");
		
		PropertyOwnerRepository testRepository = new PropertyOwnerRepositoryImpl();
		
		
		testRepository.add(test);
		
		
		System.out.println(test.getEmail());
		
		testRepository.updateEmail("4198274", "new Email");
		
		System.out.println(test.getEmail());
		
		
		
		
	}
	
}
