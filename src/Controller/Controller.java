package Controller;

import java.util.Map;

import model.AnimalPane;
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
