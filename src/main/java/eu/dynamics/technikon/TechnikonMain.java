package eu.dynamics.technikon;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
		propertyOwner.setVatNumber("100");
		propertyOwner.setName("kostas");
		propertyOwner.setAddress("papagou");
		propertyOwner.setPassword("25648");
		propertyOwner.setSurname("papadopoulos");
		propertyOwner.setPhoneNumber("2356665");
		propertyOwner.setUsername("kos");
		propertyOwner.setEmail("kostas@mail.com");
		//propertyOwnerService.addPropertyOwner(propertyOwner);

		PropertyOwner propertyOwner2 = new PropertyOwner();
		propertyOwner2.setVatNumber("200");
		propertyOwner2.setName("petros");
		propertyOwner2.setAddress("dodonis");
		propertyOwner2.setPassword("1234");
		propertyOwner2.setSurname("dimitriou");
		propertyOwner2.setPhoneNumber("210457");
		propertyOwner2.setUsername("petr");
		propertyOwner2.setEmail("petros@mail.com");
		//propertyOwnerService.addPropertyOwner(propertyOwner2);
		
		//search by mail
		//System.out.println(propertyOwnerService.searchEmail("kostas@mail.com"));
		
		//search by vatNumber
		//System.out.println(propertyOwnerService.searchVatNumber("200"));
		
		//update owner
		//propertyOwnerService.updatePropertyOwner(2L, "pesas@mail.com", "dodonis", "29292");
		
		//delete safely and display
//		System.out.println("property owner table BEFORE safely deletion");
//		System.out.println(propertyOwnerService.displayPropertyOwner());
//		System.out.println("property owner table AFTER safely deletion");
//		propertyOwnerService.deleteSafely("200");
//		System.out.println(propertyOwnerService.displayPropertyOwner());
		
		
		

		System.out.println("---------------------------- Property----------------------------");

		PropertyRepository propertyRepository = new PropertyRepositoryImpl(entityManager);
		PropertyService propertyService = new PropertyServiceImpl(propertyRepository);

		Property propertyTest = new Property();
		propertyTest.setAddress("larisa");
		propertyTest.setTypeOfProperty(TypeOfProperty.APARTMENT);
		propertyTest.setPropertyId("23456");
		propertyTest.setYearOfConstruction("2019");
		propertyTest.setPropertyOwner(propertyOwner);
		//propertyService.addProperty(propertyTest);
	

		Property propertyTest2 = new Property();

		propertyTest2.setAddress("volos");
		propertyTest2.setTypeOfProperty(TypeOfProperty.DETACHED_HOUSE);
		propertyTest2.setPropertyId("34567");
		propertyTest2.setYearOfConstruction("2019");
		propertyTest2.setPropertyOwner(propertyOwner);
		//propertyService.addProperty(propertyTest2);

		//search by property id
		//System.out.println(propertyService.searchPropertyId("23456"));
		
		//search by vatNumber
		//System.out.println(propertyService.searchVatNumber("100"));
		
		//update property
		// propertyRepository.updateProperty("34567","address","lar");

		
		//display all properties
		//System.out.println(propertyService.displayProperty());
		
		//delete property permantly 
		//propertyService.deletePermantly("23456");
		

		System.out.println("---------------------------- Property Repair----------------------------");

		PropertyRepairRepository propertyRepairRepository = new PropertyRepairRepositoryImpl(entityManager);
		PropertyRepairService propertyRepairService = new PropertyRepairServiceImpl(propertyRepairRepository);

		PropertyRepair propertyRepairTest = new PropertyRepair();
		propertyRepairTest.setScheduledDate(LocalDateTime.of(2019, 9, 9, 9, 9));
		propertyRepairTest.setDescription("repair plumbing");
		propertyRepairTest.setTypeOfRepair(TypeOfRepair.PLUMBING);
		propertyRepairTest.setStatusOfRepair(StatusOfRepair.COMPLETE);
		propertyRepairTest.setCost(new BigDecimal(150));
		propertyRepairTest.setWorkDescription("sadsadas");
		
		propertyRepairTest.setProperty(propertyTest);
		propertyRepairTest.setOwner(propertyTest.getPropertyOwner());
		//propertyRepairService.addPropertyRepair(propertyRepairTest);

		PropertyRepair propertyRepairTest2 = new PropertyRepair();
		propertyRepairTest2.setScheduledDate(LocalDateTime.of(2020, 9, 9, 9, 9));
		propertyRepairTest2.setDescription("lights repair");
		propertyRepairTest2.setTypeOfRepair(TypeOfRepair.ELECTRICAL_WORK);
		propertyRepairTest2.setStatusOfRepair(StatusOfRepair.COMPLETE);
		propertyRepairTest2.setCost(new BigDecimal(80));
		propertyRepairTest2.setWorkDescription("aaaaa");
	
		propertyRepairTest2.setProperty(propertyTest);
		propertyRepairTest2.setOwner(propertyTest.getPropertyOwner());
		//propertyRepairService.addPropertyRepair(propertyRepairTest2);
		
		
		
		//search by date
		//System.out.println(propertyRepairService.searchDate(LocalDateTime.of(2010, 2, 3, 1, 1)));
		
		//search by range of dates
		//System.out.println(propertyRepairRepository.readRangeOfDates(LocalDateTime.of(2020, 10, 9, 9, 9), LocalDateTime.of(2021, 9, 9, 9, 9)));
		
		//search users by vatnumber
		//System.out.println(propertyRepairService.searchVatNumber("46461"));
		
		
		//update property repair 
		//System.out.println(StatusOfRepair.IN_PROGRESS.toString());
		
		//System.out.println(propertyRepairService.displayPropertyRepair());
		//System.out.println(propertyRepairService.displayPropertyRepair());
		//propertyRepairService.updatePropertyRepair(1L,"description","new description");
		//System.out.println(propertyRepairService.displayPropertyRepair());
		
		//display all property repairs
		//System.out.println(propertyRepairService.displayPropertyRepair());
		
		//delete property permantly 
		//System.out.println(propertyRepository.readPropertyId("23456"));
		//propertyService.deletePermantly(2L);
		

		JpaUtil.shutdown();

	}

}
