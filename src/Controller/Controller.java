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
	
	public AnimalPane getCurrentAnimalPane();
	
	public void setCurrentAnimalPane(AnimalPane currentAnimalPane);
	
}
