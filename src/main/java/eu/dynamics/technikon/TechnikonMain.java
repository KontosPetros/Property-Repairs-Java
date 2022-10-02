package eu.dynamics.technikon;

import java.math.BigDecimal;

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
		propertyOwner.setVatNumber("421");
		propertyOwner.setName("kostas");
		propertyOwner.setAddress("papagou");
		propertyOwner.setPassword("25648");
		propertyOwner.setSurname("papadopoulos");
		propertyOwner.setPhoneNumber("2356665");
		propertyOwner.setUsername("aou");
		propertyOwner.setEmail("kostas@mail.com");
		propertyOwnerService.addPropertyOwner(propertyOwner);

		PropertyOwner propertyOwner2 = new PropertyOwner();
		propertyOwner2.setVatNumber("456");
		propertyOwner2.setName("kostas");
		propertyOwner2.setAddress("papagou");
		propertyOwner2.setPassword("25648");
		propertyOwner2.setSurname("papadopoulos");
		propertyOwner2.setPhoneNumber("2356665");
		propertyOwner2.setUsername("aou");
		propertyOwner2.setEmail("1s@mail.com");
		propertyOwnerService.addPropertyOwner(propertyOwner2);

//		System.out.println(propertyOwnerService.searchEmail("kostas@mail.com"));
//		System.out.println(propertyOwnerService.searchVatNumber("456"));
//		propertyOwnerService.updatePropertyOwner(3L, "kostas@mail.com", "dodonis", "29292");
//		System.out.println("property owner table BEFORE safely deletion");
//		System.out.println(propertyOwnerService.displayPropertyOwner());
//		System.out.println("property owner table AFTER safely deletion");
//		propertyOwnerService.deleteSafely("421");
//		System.out.println(propertyOwnerService.displayPropertyOwner());

		System.out.println("---------------------------- Property----------------------------");

		PropertyRepository propertyRepository = new PropertyRepositoryImpl(entityManager);
		PropertyService propertyService = new PropertyServiceImpl(propertyRepository);

		Property propertyTest = new Property();
		propertyTest.setAddress("larisa");
		propertyTest.setTypeOfProperty(TypeOfProperty.APARTMENT);
		propertyTest.setPropertyID("23456");
		propertyTest.setYearOfConstruction("2019");
		propertyTest.setPropertyOwner(propertyOwner);
		propertyService.addProperty(propertyTest);

		Property propertyTest2 = new Property();

		propertyTest2.setAddress("volos");
		propertyTest2.setTypeOfProperty(TypeOfProperty.APARTMENT);
		propertyTest2.setPropertyID("34567");
		propertyTest2.setYearOfConstruction("2019");
		propertyTest2.setPropertyOwner(propertyOwner);
		propertyService.addProperty(propertyTest2);

		// System.out.println(propertyService.searchPropertyId("34567"));

		System.out.println(propertyService.searchVatNumber("421"));

		System.out.println("---------------------------- Property Repair----------------------------");

		PropertyRepairRepository propertyRepairRepository = new PropertyRepairRepositoryImpl(entityManager);
		PropertyRepairService propertyRepairService = new PropertyRepairServiceImpl(propertyRepairRepository);

		PropertyRepair propertyRepairTest = new PropertyRepair();
		propertyRepairTest.setScheduledDate(null);
		propertyRepairTest.setDescription("repair");
		propertyRepairTest.setTypeOfRepair(TypeOfRepair.ELECTRICAL_WORK);
		propertyRepairTest.setStatusOfRepair(StatusOfRepair.COMPLETE);
		propertyRepairTest.setCost(new BigDecimal(150));
		propertyRepairTest.setWorkDescription("sadsadas");
		propertyRepairTest.setProperty(propertyTest);
		propertyRepairTest.setOwner(propertyTest.getPropertyOwner());
		propertyRepairService.addPropertyRepair(propertyRepairTest);

		PropertyRepair propertyRepairTest2 = new PropertyRepair();
		propertyRepairTest2.setScheduledDate(null);
		propertyRepairTest2.setDescription("2o repair");
		propertyRepairTest2.setTypeOfRepair(TypeOfRepair.ELECTRICAL_WORK);
		propertyRepairTest2.setStatusOfRepair(StatusOfRepair.COMPLETE);
		propertyRepairTest2.setCost(new BigDecimal(150));
		propertyRepairTest2.setWorkDescription("sadsadas");
		propertyRepairTest2.setProperty(propertyTest);
		propertyRepairTest2.setOwner(propertyTest.getPropertyOwner());
		propertyRepairService.addPropertyRepair(propertyRepairTest2);

		JpaUtil.shutdown();

	}

}
