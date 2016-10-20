package Controller;

import java.util.Map;
import model.AnimalPane;
import View.AnimalPaneGUI;

/**
 * 
 * @author Jordan Frazier
 *
 */
public interface Controller {

	
	public Map<Integer, String[]> handleInput(String input);
	
//	public AnimalPane getActiveAnimalPane();
	
	public AnimalPaneGUI getActiveAnimalPaneGUI();
	
//	public void setActiveAnimalPane(AnimalPane currentAnimalPane);
	
	public void setActiveAnimalPaneGUI(AnimalPaneGUI currentAnimalPaneGUI);
	
}
