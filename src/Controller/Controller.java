package Controller;

import java.util.Map;

import Model.AnimalPane;
/**
 * 
 * @author Jordan Frazier
 *
 */
public interface Controller {

	
	public Map<Integer, String[]> handleInput(String input);
	
	public AnimalPane getActiveAnimalPane();
	
	public void setActiveAnimalPane(AnimalPane currentAnimalPane);
	
}
