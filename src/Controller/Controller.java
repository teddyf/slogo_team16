package Controller;

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
	
	public AnimalPaneGUI getActiveAnimalPaneGUI();
	
	public void setActiveAnimalPaneGUI(AnimalPaneGUI currentAnimalPaneGUI);

	public void setParsingLanguage(String language);
}
