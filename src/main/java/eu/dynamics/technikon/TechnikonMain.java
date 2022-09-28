package eu.dynamics.technikon;

import java.sql.Connection;

import eu.dynamics.technikon.domain.PropertyOwner;
import eu.dynamics.technikon.jpautil.JpaUtil;
import eu.dynamics.technikon.service.PropertyOwnerService;
import eu.dynamics.technikon.service.impl.PropertyOwnerServiceImpl;

import jakarta.persistence.EntityManager;

public class TechnikonMain {

	public static void main(String[] args) {
		EntityManager entityManager = JpaUtil.getEntityManager();

//		System.out.println("---------------------------- PropertyOwner----------------------------");
//		PropertyOwner test = new PropertyOwner("4198274", "petros", " kontos", " ioannina", " 123", "email", "pe",
//				"123");
//
//		PropertyOwnerRepository testRepository = new PropertyOwnerRepositoryImpl();
//		testRepository.add(test);
//		System.out.println(test.getEmail());
//		testRepository.updateEmail("4198274", "new Email");
//		System.out.println(test.getEmail());
//		System.out.println("before: " + testRepository.read().contains(test));
//		testRepository.deleteSafely("4198274");
//		System.out.println("after: " + testRepository.read().contains(test));
//		
//
//		System.out.println("---------------------------- PropertyRepair----------------------------");
//		PropertyRepair test2 = new PropertyRepair(LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40), "Description",
//				TypeOfRepair.ELECTRICAL_WORK, StatusOfRepair.COMPLETE, new BigDecimal(100), "123", "561", "JSAFNB");
//
//		PropertyRepairRepository test2Repository = new PropertyRepairRepositoryImpl();
//
//		test2Repository.add(test2);
//		System.out.println(test2Repository.readRangeOfDates(LocalDateTime.of(2016, Month.JULY, 29, 19, 30, 40),
//				LocalDateTime.of(2019, Month.JULY, 29, 19, 30, 40)));
//
//		Connection connection = JDBCConnection.getConnection();
//		PropertyOwnerService propertyOwnerService = new PropertyOwnerServiceImpl(connection);
//		propertyOwnerService.createTable();
//		propertyOwnerService.insertPropertyOwner(
//				new PropertyOwner("123456", "petros", " kontos", " ioannina", " 123", "email", "pe", "123"));
//		propertyOwnerService.insertPropertyOwner(
//				new PropertyOwner("654321", "kwstas", " sadads", " dadasda", " 897", "k@gmail", "ka", "456"));
//		
		
//      System.out.println(propertyOwnerService.findAll());
	}

}
