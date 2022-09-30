package eu.dynamics.technikon;

import eu.dynamics.technikon.jpautil.JpaUtil;
import eu.dynamics.technikon.model.Property;
import eu.dynamics.technikon.model.PropertyOwner;
import eu.dynamics.technikon.model.PropertyRepair;
import eu.dynamics.technikon.model.StatusOfRepair;
import eu.dynamics.technikon.model.TypeOfProperty;
import eu.dynamics.technikon.model.TypeOfRepair;
import eu.dynamics.technikon.repository.PropertyOwnerRepository;
import eu.dynamics.technikon.repository.PropertyRepairRepository;
import eu.dynamics.technikon.repository.PropertyRepository;
import eu.dynamics.technikon.repository.impl.PropertyOwnerRepositoryImpl;
import eu.dynamics.technikon.repository.impl.PropertyRepairRepositoryImpl;
import eu.dynamics.technikon.repository.impl.PropertyRepositoryImpl;
import eu.dynamics.technikon.service.PropertyOwnerService;
import eu.dynamics.technikon.service.PropertyRepairService;
import eu.dynamics.technikon.service.PropertyService;
import eu.dynamics.technikon.service.impl.PropertyOwnerServiceImpl;
import eu.dynamics.technikon.service.impl.PropertyRepairServiceImpl;
import eu.dynamics.technikon.service.impl.PropertyServiceImpl;
import jakarta.persistence.EntityManager;

public class TechnikonMain {

	public static void main(String[] args) throws Exception {
		EntityManager entityManager = JpaUtil.getEntityManager();

		System.out.println("---------------------------- PropertyOwner----------------------------");
		PropertyOwnerRepository propertyOwnerRepository = new PropertyOwnerRepositoryImpl(entityManager);
		PropertyOwnerService propertyOwnerService = new PropertyOwnerServiceImpl(propertyOwnerRepository);
		PropertyOwner propertyOwner = new PropertyOwner();
		propertyOwner.setVatNumber("15264");
		propertyOwner.setName("kostas");
		propertyOwner.setAddress("papagou");
		propertyOwner.setPassword("25648");
		propertyOwner.setSurname("papadopoulos");
		propertyOwner.setPhoneNumber("2356665");
		propertyOwner.setUsername("aou");
		propertyOwner.setEmail("gog@mail.com");

		propertyOwnerService.addPropertyOwner(propertyOwner);
		
		PropertyRepository propertyRepository = new PropertyRepositoryImpl(entityManager);
		PropertyService propertyService = new PropertyServiceImpl(propertyRepository);
		Property propertyTest = new Property();
		propertyTest.setAddress("volos");
		propertyTest.setTypeOfProperty(TypeOfProperty.APARTMENT);
		propertyTest.setPropertyID("12345");
		propertyTest.setYearOfConstruction("2019");	
		propertyTest.setPropertyOwner(propertyOwner);
		propertyService.addProperty(propertyTest);
		
		PropertyRepairRepository propertyRepairRepository = new PropertyRepairRepositoryImpl(entityManager);
		PropertyRepairService propertyRepairService = new PropertyRepairServiceImpl(propertyRepairRepository);
		PropertyRepair propertyRepairTest = new PropertyRepair();
		propertyRepairTest.setScheduledDate(null);
		propertyRepairTest.setDescription("sadsa");
		propertyRepairTest.setTypeOfRepair(TypeOfRepair.ELECTRICAL_WORK);
		propertyRepairTest.setStatusOfRepair(StatusOfRepair.COMPLETE);
		propertyRepairTest.setCost(null);
		propertyRepairTest.setWorkDescription("sadsadas");
		propertyRepairTest.setProperty(propertyTest);
		propertyRepairTest.setOwnerID(propertyTest.getPropertyOwner().getVatNumber());
        propertyRepairService.addPropertyRepair(propertyRepairTest);
		
		

//		System.out.println("---------------------------- Property----------------------------");
//
//		PropertyService propertyService = new PropertyServiceImpl(entityManager);
//		Property propertyTest = new Property();
//		propertyTest.setAddress("volos");
//		propertyTest.setTypeOfProperty(TypeOfProperty.APARTMENT);
//		propertyTest.setPropertyID("12345");
//		propertyTest.setYearOfConstruction("2019");
//		propertyTest.setVatNumber(propertyOwner.getVatNumber());
//		propertyService.addProperty(propertyTest);

//		
		// PropertyOwner test = new PropertyOwner("4198274", "petros", " kontos", "
		// ioannina", " 123", "email", "pe",
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
