package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import View.helper.Coordinate;
import View.helper.PenContainer;
import model.animal.Animal;
import model.animal.Turtle;
/**
 * This class represents the back end aspect of the pane that the animal is displayed in. 
 * It's corresponding front end class is AnimalPaneGUI, and one AnimalPane should be created
 * for each AnimalPaneGUI that is created. 
 * This class is an observable, for when a coordinate map is set for animation to follow. 
 * Deprecated: Observer/update methods. 
 * AnimalPane is the backend implementation of AnimalPane GUI and holds all of
 * the information needed to populate the turtle grid on the front end
 * 
 * @author Jordan Frazier
 * @author lucyzhang
 *
 */
public class AnimalPane extends Observable implements Observer {

	private Map<Integer, Animal> myAnimalMap = new HashMap<>();
	private List<Animal> myAnimalList;
	private List<String> myCommandHistory;

	private Map<String, String> myVariables;

	private Map<Integer, List<Coordinate>> coordinateMap;
	private List<Coordinate> coordinateList;

	private PenContainer penColor;

	private int animalID;

	public AnimalPane() {
		// this increments when adding new animals
		animalID = 0;

		myAnimalMap = new HashMap<Integer, Animal>();
		myAnimalList = new ArrayList<Animal>();

		myVariables = new HashMap<String, String>();

		myCommandHistory = new ArrayList<String>();

		coordinateList = new ArrayList<Coordinate>();
		coordinateMap = new HashMap<Integer, List<Coordinate>>();

		penColor = new PenContainer();

	}

	/**
	 * Adds an animal on the backend and sets it up with observer
	 * 
	 * @return the animal
	 */
	public Animal addAnimal() {
		animalID++;
		Animal animal = new Turtle(penColor);

		penColor.addObserver(animal.getActualPen());

		myAnimalMap.put(animalID, animal);
		myAnimalList.add(animal);

		animal.setId(animalID);
		animal.addObserver(this);
		return animal;
	}

	/**
	 * Adds animal and notifies view that a new animal needs to be displayed
	 * 
	 * @param animal
	 */
	public void addAnimal(Animal animal) {

		System.out.println("Added animal in backend AnimalPane");
		animalID++;

		penColor.addObserver(animal.getActualPen());

		myAnimalMap.put(animalID, animal);
		myAnimalList.add(animal);

		animal.setId(animalID);
		animal.addObserver(this);

	}

	/**
	 * Remove non active animals
	 * 
	 * @param animal
	 */
	public void removeAnimal(Animal animal) {
		myAnimalMap.remove(animal.getId());
		myAnimalList.remove(animal);
	}

	@Deprecated
	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof Animal) {
			Animal cur = (Animal) o;
			for (int animalId : myAnimalMap.keySet()) {
				if (animalId == cur.getId()) { // I think this will hit them all
												// no matter what
					// TODO: update animalPane.

					if (cur.getSelected()) {
						// now update this guy
					}

				}
			}
		}
	}

	public Map<Integer, Animal> getMyAnimalMap() {
		return myAnimalMap;
	}

	public List<String> getMyCommandHistory() {
		return myCommandHistory;
	}

	public Map<String, String> getMyVariables() {
		return myVariables;
	}

	public Map<Integer, List<Coordinate>> getCoordinateMap() {
		return coordinateMap;
	}

	public List<Coordinate> getCoordinateList() {
		return coordinateList;
	}

	public int getAnimalID() {
		return animalID;
	}

	public void setMyAnimalMap(Map<Integer, Animal> myAnimalMap) {
		this.myAnimalMap = myAnimalMap;
	}

	public void setMyCommandHistory(List<String> myCommandHistory) {
		this.myCommandHistory = myCommandHistory;
	}

	public void setMyVariables(Map<String, String> myVariables) {
		this.myVariables = myVariables;
	}

	public void setCoordinateMap(Map<Integer, List<Coordinate>> coordinateMap) {
		for (Integer id : coordinateMap.keySet()) {
			this.coordinateMap.put(id, coordinateMap.get(id));
		}
	}

	/**
	 * Signals animation to update
	 */
	public void signalAnimation() {
		setChanged();
		notifyObservers();
	}

	/**
	 * Clears all of the stored animals
	 */
	public void clearAnimals() {
		myAnimalList.clear();
		myAnimalMap.clear();
	}

	public void setAnimalID(int animalID) {
		this.animalID = animalID;
	}

	public List<Animal> getMyAnimalList() {
		return myAnimalList;
	}

	public void setMyAnimalList(List<Animal> myAnimalList) {
		this.myAnimalList = myAnimalList;
	}

	public PenContainer getPenContainer() {
		return penColor;
	}

	public void setPenContainer(PenContainer penColor) {
		this.penColor = penColor;
	}
}
