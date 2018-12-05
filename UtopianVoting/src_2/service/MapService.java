package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import controller.MapController;
import domain.Continent;
import domain.Territory;

/**
 * This class is used to handle all the service calls from {@link MapController}
 * class. This is used to implement required business logic.
 * 
 * @author Yogesh
 *
 */
public class MapService {

	/**
	 * This variable holds the constant value to used while parsing the file.
	 */
	private static final String CONTINENT_KEY = "[Continents]";

	/**
	 * This variable holds the constant value to used while parsing the file.
	 */
	private static final String TERRITORY_KEY = "[Territories]";

	/**
	 * This method is used to validate that whether the map in application memory is
	 * valid map or not.
	 * 
	 * @author karanbhalla
	 * @param continentsSet:
	 *            Set which represent continent object.
	 * @param territoriesSet:
	 *            Set which represent territories object.
	 * @param errorList:
	 *            An ArrayList to store validation errors.
	 */
	public void validateMap(Set<Continent> continentsSet, Set<Territory> territoriesSet, List<String> errorList) {

		String errorMessage = new String();
		Map<String, Boolean> ifTerritoryInContinent = new HashMap<>();

		Iterator<Continent> iteContinent = continentsSet.iterator();
		Iterator<Territory> iteTerritory = territoriesSet.iterator();
		// providing error message in case if no continent or territory present in map
		// in application memory
		if (continentsSet.size() < 1 || territoriesSet.size() < 1) {
			errorMessage = "No Continent or Territory Exist";
			errorList.add(errorMessage);
			return;
		}

		// logic for validating if territory is present in a continent and if a
		// territory is present in more than one continent
		while (iteContinent.hasNext()) {
			Continent continent = iteContinent.next();
			if (continent.getTerritories().size() < 1) {
				errorMessage = continent.getName() + " Does Not Have Any Territory in it";
				errorList.add(errorMessage);
			}
			List<Territory> territoryList = continent.getTerritories();
			for (int i = 0; i < territoryList.size(); i++) {
				if (ifTerritoryInContinent.get(territoryList.get(i).getName()) != null) {
					errorMessage = "Territory " + territoryList.get(i).getName()
							+ " is present in more than one Continent";
					errorList.add(errorMessage);
				} else {
					ifTerritoryInContinent.put(territoryList.get(i).getName(), true);
				}

			}

		}
		// logic for validating neighborhood territories
		boolean ifNeighbourPresent = true;
		while (iteTerritory.hasNext()) {
			Territory territory = iteTerritory.next();
			if (territory.getNeighbourTerritories().size() < 1) {
				errorMessage = territory.getName() + " does not have any neighbouring territory";
				errorList.add(errorMessage);
				ifNeighbourPresent = false;
			}
		}

		if (!ifNeighbourPresent) {
			errorMessage = "The graph you entered is unconnected";
			errorList.add(errorMessage);
			return;
		}
		iteTerritory = territoriesSet.iterator();
		Set<Territory> testingQueue = new HashSet<>();

		checkConnectedGraph(iteTerritory.next().getNeighbourTerritories().get(0), testingQueue, null);
		if (testingQueue.size() != territoriesSet.size()) {
			errorMessage = "The graph you entered is unconnected";
			errorList.add(errorMessage);

		}
		iteContinent = continentsSet.iterator();
		// logic shows territories not connected
		while (iteContinent.hasNext()) {
			testingQueue = new HashSet<>();
			Continent contObject = iteContinent.next();
			checkConnectedGraph(contObject.getTerritories().get(0), testingQueue, contObject);
			if (testingQueue.size() != contObject.getTerritories().size()) {
				errorMessage = "Territories in " + contObject.getName() + " are not connected ";
				errorList.add(errorMessage);
			}
		}
	}

	/**
	 * This is a DFS function to check that whether the graph is connected or not.
	 * 
	 * @author karanbhalla
	 * 
	 * @param territoryObject:
	 *            A starting object of Territory, could be any Territory.
	 * @param queueForChecking:
	 *            A set to keep the Territories
	 * @param continentOfTerritory:
	 *            A continent object referring to a continent whose territories we
	 *            are traversing. It will be null for the case when we will check
	 *            that if the whole graph is connected or not.
	 */
	private void checkConnectedGraph(Territory territoryObject, Set<Territory> queueForChecking,
			Continent continentOfTerritory) {

		for (int i = 0; i < territoryObject.getNeighbourTerritories().size(); i++) {

			Territory neighbouringTerritory = territoryObject.getNeighbourTerritories().get(i);
			if (continentOfTerritory == null && !queueForChecking.contains(neighbouringTerritory)) {
				queueForChecking.add(neighbouringTerritory);
				checkConnectedGraph(neighbouringTerritory, queueForChecking, continentOfTerritory);
			} else if (!queueForChecking.contains(neighbouringTerritory)
					&& neighbouringTerritory.getContinent().getName() == continentOfTerritory.getName()
					&& neighbouringTerritory.getNeighbourTerritories().size() != 0) {
				queueForChecking.add(neighbouringTerritory);
				checkConnectedGraph(neighbouringTerritory, queueForChecking, continentOfTerritory);
			}
		}

	}

	/**
	 * This method is used to save the created/modified map as a file.
	 * 
	 * @param file:
	 *            File object to which file needs to be written and save.
	 * @param continentsSet:
	 *            Set of all the continents in map.
	 * @param territoriesSet:
	 *            Set of all the territories in map.
	 * @return boolean: true if file is save else false.
	 */
	public boolean saveMap(File file, HashSet<Continent> continentsSet, HashSet<Territory> territoriesSet) {

		try {
			PrintWriter writer = new PrintWriter(file);

			// writing static content to map file.
			writer.println("[Map]");
			writer.println("image=default.bmp");
			writer.println("wrap=default");
			writer.println("scroll=default");
			writer.println("author=default");
			writer.println("warn=default\n");
			writer.println("[Continents]");

			// traversing over continents and territories to write them to file.
			for (Continent continent : continentsSet)
				writer.println(continent + "=" + continent.getContinentArmyValue());

			writer.println("\n[Territories]");
			for (Territory parentTerritory : territoriesSet) {
				writer.print(parentTerritory + ",0,0," + parentTerritory.getContinent());
				for (Territory childTerritory : parentTerritory.getNeighbourTerritories())
					writer.print("," + childTerritory);
				writer.println();
			}
			writer.close();
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * This method is using the File object in order to access the file and parse
	 * it's contents. It will call the rendering Class method which will render the
	 * map on UI.
	 * 
	 * 
	 * @author Kunal
	 *
	 * @param file:
	 *            This object is passed from the <u>class</u> where we choose a
	 *            particular map file.
	 *
	 * @param modifyOrPlay:
	 *            true if this method is called for modifying the exisiting map else
	 *            false if called to play.
	 *
	 * @throws Exception:
	 *             Throw file not found and other custom exceptions.
	 */
	public void parseFile(File file, List<String> errorList) {
		String errormessage = new String();
		boolean isFileEmpty = (file != null) ? true : false;
		if (!isFileEmpty) {
			errormessage = "File not Found";
			errorList.add(errormessage);
			return;
		}

		Set<Territory> territoryObjectSet = new HashSet<>();
		Set<Continent> continentObjectSet = new HashSet<>();
		Continent continentObject;
		Territory territoryObject;
		Territory tempTerritoryObject;
		ArrayList<Territory> neighbouringTerritories;
		HashMap<String, ArrayList<Territory>> continentToTerritoryMap = null;
		HashMap<String, Territory> ifTerritoryObject;
		HashMap<String, Continent> ifContinentObject = null;
		ArrayList<Territory> territoryInAContinentList;

		BufferedReader bufferedReaderObject;
		try {

			bufferedReaderObject = new BufferedReader(new FileReader(file));

			String fileContents;

			// This is how we are reading the continent and territories and their
			// relation from the map. As, map files have a certain format so this code
			// deducts needed entities and relationship among them according to the format
			try {
				while ((fileContents = bufferedReaderObject.readLine()) != null) {

					if (fileContents.equals(MapService.CONTINENT_KEY)) {
						ifContinentObject = new HashMap<>();
						fileContents = bufferedReaderObject.readLine();

						// used do-while as there is blank space between continents and territories in
						// files
						do {
							if (!fileContents.contains("=")) {
								errormessage = "No Continent is present in the File";
								errorList.add(errormessage);
								return;
							}
							String[] lineContent = fileContents.split("=");
							String continentName = lineContent[0];
							int continentArmyValue = Integer.parseInt(lineContent[1]);
							continentObject = new Continent(continentName, continentArmyValue);
							continentObjectSet.add(continentObject);
							ifContinentObject.put(continentName, continentObject);
							fileContents = bufferedReaderObject.readLine();

						} while (!fileContents.isEmpty());
					}

					// logic makes territory set and continent-territory relation
					if (fileContents.equals(MapService.TERRITORY_KEY)) {
						fileContents = bufferedReaderObject.readLine();
						continentToTerritoryMap = new HashMap<>();
						ifTerritoryObject = new HashMap<>();

						do {
							if (fileContents.isEmpty()) {
								fileContents = bufferedReaderObject.readLine();
								continue;
							}

							if (!fileContents.contains(",")) {
								errormessage = "No Territory is present in the File";
								errorList.add(errormessage);
								return;
							}
							String[] lineContent = fileContents.split(",");

							String territoryName = lineContent[0];
							String continentName;

							// lineContent[1] and lineContent[2] are random integers
							if (lineContent.length > 3) {
								continentName = lineContent[3];
								neighbouringTerritories = new ArrayList<>();
								territoryInAContinentList = new ArrayList<Territory>();

								for (int i = 4; i < lineContent.length; i++) {
									tempTerritoryObject = new Territory(lineContent[i]);
									if (ifTerritoryObject.get(tempTerritoryObject.getName()) == null) {
										ifTerritoryObject.put(tempTerritoryObject.getName(), tempTerritoryObject);
										neighbouringTerritories.add(tempTerritoryObject);
									} else {
										neighbouringTerritories
												.add(ifTerritoryObject.get(tempTerritoryObject.getName()));
									}

								}
								territoryObject = new Territory(territoryName);
								if (ifTerritoryObject.get(territoryObject.getName()) != null) {
									territoryObject = ifTerritoryObject.get(territoryObject.getName());
									territoryObject.setContinent(ifContinentObject.get(continentName));
									territoryObject.setNeighbourTerritories(neighbouringTerritories);

								} else {
									territoryObject.setName(territoryName);
									territoryObject.setContinent(ifContinentObject.get(continentName));
									territoryObject.setNeighbourTerritories(neighbouringTerritories);
									ifTerritoryObject.put(territoryObject.getName(), territoryObject);
								}
								if (continentToTerritoryMap.get(continentName) != null) {
									continentToTerritoryMap.get(continentName).add(territoryObject);
								} else {
									territoryInAContinentList.add(territoryObject);
									continentToTerritoryMap.put(continentName, territoryInAContinentList);
								}
								territoryObjectSet.add(territoryObject);
							}
							fileContents = bufferedReaderObject.readLine();

						} while (fileContents != null);
					}
				}
			} catch (NumberFormatException e) {
				errorList.add("Unable to parse string to number for continent control value.");
				return;
			} catch (IOException e) {
				errorList.add("Problem reading provided file.");
				return;
			}

			Iterator<Continent> iteratorObject = continentObjectSet.iterator();

			while (iteratorObject.hasNext()) {
				Continent continentToSetTerritories = iteratorObject.next();
				List<Territory> abc = continentToTerritoryMap.get(continentToSetTerritories.getName());
				continentToSetTerritories.setTerritories(abc);
			}

			MapController.continentsSet = (HashSet<Continent>) continentObjectSet;
			MapController.territoriesSet = (HashSet<Territory>) territoryObjectSet;

		} catch (FileNotFoundException e) {
			errorList.add("Unable to find given file to parse.");
			return;
		}
	}

}