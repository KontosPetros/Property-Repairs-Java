package eu.dynamics.technikon;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

import eu.dynamics.technikon.domain.PropertyOwner;
import eu.dynamics.technikon.domain.PropertyRepair;
import eu.dynamics.technikon.domain.StatusOfRepair;
import eu.dynamics.technikon.domain.TypeOfRepair;
import eu.dynamics.technikon.repository.PropertyOwnerRepository;
import eu.dynamics.technikon.repository.PropertyRepairRepository;
import eu.dynamics.technikon.repository.impl.PropertyOwnerRepositoryImpl;
import eu.dynamics.technikon.repository.impl.PropertyRepairRepositoryImpl;

public class TechnikonMain {

	public static void main(String[] args) {

		
		
		System.out.println("---------------------------- PropertyOwner----------------------------");
		PropertyOwner test = new PropertyOwner("4198274", "petros", " kontos", " ioannina", " 123", "email", "pe",
				"123");

		PropertyOwnerRepository testRepository = new PropertyOwnerRepositoryImpl();
		testRepository.add(test);
		System.out.println(test.getEmail());
		testRepository.updateEmail("4198274", "new Email");
		System.out.println(test.getEmail());
		System.out.println("before: " + testRepository.read().contains(test));
		testRepository.deleteSafely("4198274");
		System.out.println("after: " + testRepository.read().contains(test));
		

		System.out.println("---------------------------- PropertyRepair----------------------------");
		PropertyRepair test2 = new PropertyRepair(LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40), "Description",
				TypeOfRepair.ELECTRICAL_WORK, StatusOfRepair.COMPLETE, new BigDecimal(100), "123", "561", "JSAFNB");

		PropertyRepairRepository test2Repository = new PropertyRepairRepositoryImpl();

		test2Repository.add(test2);
		System.out.println(test2Repository.readRangeOfDates(LocalDateTime.of(2016, Month.JULY, 29, 19, 30, 40),
				LocalDateTime.of(2019, Month.JULY, 29, 19, 30, 40)));

		
		
		
		
		

	}

}
