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
		propertyOwner.setVatNumber("421");
		propertyOwner.setName("kostas");
		propertyOwner.setAddress("papagou");
		propertyOwner.setPassword("25648");
		propertyOwner.setSurname("papadopoulos");
		propertyOwner.setPhoneNumber("2356665");
		propertyOwner.setUsername("aou");
		propertyOwner.setEmail("kostas@mail.com");

		propertyOwnerService.addPropertyOwner(propertyOwner);

		System.out.println("---------------------------- Property----------------------------");

		PropertyRepository propertyRepository = new PropertyRepositoryImpl(entityManager);
		PropertyService propertyService = new PropertyServiceImpl(propertyRepository);
		Property propertyTest = new Property();
		propertyTest.setAddress("volos");
		propertyTest.setTypeOfProperty(TypeOfProperty.APARTMENT);
		propertyTest.setPropertyID("12345");
		propertyTest.setYearOfConstruction("2019");
		propertyTest.setPropertyOwner(propertyOwner);
		propertyService.addProperty(propertyTest);

		System.out.println("---------------------------- PropertyRepair----------------------------");

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

		System.out.println(propertyOwnerService.searchVatNumber("13"));
	}

}
