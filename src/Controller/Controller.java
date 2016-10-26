package Controller;

import java.util.Map;
import model.AnimalPane;
import View.AnimalPaneGUI;

/**
 * 
 * @author Jordan Frazier
 * @author lucyzhang
 *
 */
public interface Controller {

	public void writeInputToFile(String input);
	
	public void handleInput();
	
//	public AnimalPane getActiveAnimalPane();
	
	public AnimalPaneGUI getActiveAnimalPaneGUI();
	
//	public void setActiveAnimalPane(AnimalPane currentAnimalPane);
	
	public void setActiveAnimalPaneGUI(AnimalPaneGUI currentAnimalPaneGUI);

	
}
