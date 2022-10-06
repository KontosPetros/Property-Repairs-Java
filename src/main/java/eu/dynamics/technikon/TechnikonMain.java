package eu.dynamics.technikon;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
import eu.dynamics.technikon.utility.CSVReader;
import eu.dynamics.technikon.utility.Reader;
import jakarta.persistence.EntityManager;

public class TechnikonMain {

	public static void main(String[] args) throws Exception {
		
		
		EntityManager entityManager = JpaUtil.getEntityManager();
		
		
		Reader csvReader = new CSVReader();
		List<String> propertyOwnerList = csvReader.read("C:\\Users\\Petros\\Desktop\\propertyOwners.csv");
		List<String> propertyList = csvReader.read("C:\\Users\\Petros\\Desktop\\Properties.csv");
		List<String> propertyRepairList = csvReader.read("C:\\Users\\Petros\\Desktop\\PropertyRepair.csv");
		

		System.out.println("---------------------------- PropertyOwner----------------------------");
		PropertyOwnerRepository propertyOwnerRepository = new PropertyOwnerRepositoryImpl(entityManager);
		PropertyOwnerService propertyOwnerService = new PropertyOwnerServiceImpl(propertyOwnerRepository);
		propertyOwnerService.loadPropertyOwnerData(propertyOwnerList);
		
		
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
		propertyService.loadPropertyData(propertyList,propertyOwnerService);
		
		
		
		
		//propertyService.loadPropertyData(propertyList);
		
		//update Property
//       Property propertyUpdate = propertyService.searchPropertyId("34567");
//       propertyUpdate.setAddress("Thessaloniki");
//       propertyService.updateProperty(propertyUpdate);
		
		

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
		propertyRepairService.loadPropertyRepairData(propertyRepairList,propertyOwnerService,propertyService);
		
		
//		   //update PropertyRepair
//	       PropertyRepair propertyRepairUpdate = propertyRepairService.searchPropertyRepairId(1L);
//	       propertyRepairUpdate.setDescription("doors repair");
//	       propertyRepairService.updatePropertyRepair(propertyRepairUpdate);
		
		
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
