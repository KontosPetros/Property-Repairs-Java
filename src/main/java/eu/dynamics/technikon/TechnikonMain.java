package eu.dynamics.technikon;

import java.time.LocalDateTime;
import java.util.List;

import eu.dynamics.technikon.jpautil.JpaUtil;
import eu.dynamics.technikon.model.Property;
import eu.dynamics.technikon.model.PropertyRepair;
import eu.dynamics.technikon.model.StatusOfRepair;
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
import eu.dynamics.technikon.utility.CSVReader;
import eu.dynamics.technikon.utility.Reader;
import jakarta.persistence.EntityManager;

public class TechnikonMain {

	public static void main(String[] args) throws Exception {

		EntityManager entityManager = JpaUtil.getEntityManager();

		System.out.println("READ CSV FILES");
		Reader csvReader = new CSVReader();
		List<String> propertyOwnerList = csvReader.read("C:\\Users\\Petros\\Desktop\\propertyOwners.csv");
		List<String> propertyList = csvReader.read("C:\\Users\\Petros\\Desktop\\Properties.csv");
		List<String> propertyRepairList = csvReader.read("C:\\Users\\Petros\\Desktop\\PropertyRepair.csv");

		System.out.println("LOAD PROPERTY OWNER DATA");
		PropertyOwnerRepository propertyOwnerRepository = new PropertyOwnerRepositoryImpl(entityManager);
		PropertyOwnerService propertyOwnerService = new PropertyOwnerServiceImpl(propertyOwnerRepository);
		// propertyOwnerService.loadPropertyOwnerData(propertyOwnerList);

		System.out.println("LOAD PROPERTY DATA");
		PropertyRepository propertyRepository = new PropertyRepositoryImpl(entityManager);
		PropertyService propertyService = new PropertyServiceImpl(propertyRepository);
		// propertyService.loadPropertyData(propertyList,propertyOwnerService);

		System.out.println("LOAD PROPERTY REPAIR DATA");
		PropertyRepairRepository propertyRepairRepository = new PropertyRepairRepositoryImpl(entityManager);
		PropertyRepairService propertyRepairService = new PropertyRepairServiceImpl(propertyRepairRepository);
		// propertyRepairService.loadPropertyRepairData(propertyRepairList,propertyOwnerService,propertyService);

		// search by mail
		// System.out.println(propertyOwnerService.searchEmail("kosta@mail.com"));

		// search by vatNumber
		// System.out.println(propertyOwnerService.searchVatNumber("101213"));

		// update owner
		// propertyOwnerService.updatePropertyOwner(2L, "pesas@mail.com", "dodonis",
		// "new password");

		// delete safely and display
//		System.out.println("property owner table BEFORE safely deletion");
//		propertyOwnerService.displayPropertyOwner().forEach(System.out::println);
//		
//		propertyOwnerService.deleteSafely("151617");
//		
//		System.out.println("property owner table AFTER safely deletion");
//		propertyOwnerService.displayPropertyOwner().forEach(System.out::println);

		// search by property id
		// System.out.println(propertyService.searchPropertyId("5461"));

		// search by vatNumber
		// propertyService.searchVatNumber("201213").forEach(System.out::println);

		// update Property
//		Property propertyUpdate = propertyService.findPropertyById(2L);
//		propertyUpdate.setAddress("Thessaloniki");
//		propertyService.updateProperty(propertyUpdate);

		// display all properties
		// propertyService.displayProperty().forEach(System.out::println);

		// delete property permantly
		// propertyService.deletePermantly(1L);

		// search by date
		// propertyRepairService.searchDate(LocalDateTime.of(2023, 4, 1, 10, 10,
		// 30)).forEach(System.out::println);

		// search by range of dates
		// propertyRepairRepository.readRangeOfDates(LocalDateTime.of(2020, 10, 9, 9,
		// 9), LocalDateTime.of(2025, 9, 9, 9, 9)).forEach(System.out::println);

		// search users by vatnumber
		// propertyRepairService.searchVatNumber("201213").forEach(System.out::println);

//		   update PropertyRepair
//	       PropertyRepair propertyRepairUpdate = propertyRepairService.searchPropertyRepairId(3L);
//	       propertyRepairUpdate.setStatusOfRepair(StatusOfRepair.IN_PROGRESS);
//	       propertyRepairService.updatePropertyRepair(propertyRepairUpdate);

		// display all property repairs
		// propertyRepairService.displayPropertyRepair().forEach(System.out::println);

//		propertyRepairService.displayPropertyRepair().forEach(System.out::println);
//		propertyRepairService.deleteSafely(5L);
//		propertyRepairService.displayPropertyRepair().forEach(System.out::println);

		JpaUtil.shutdown();

	}

}
