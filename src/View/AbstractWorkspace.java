package View;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
/**
 * 
 * @author Jordan Frazier
 *
 */
// TODO: - Jordan fix this abstract view
public interface AbstractWorkspace {
	
	public void init(SlogoView view);
	
	public <T> ComboBox<? extends T> createLanguageChooser();
	
	public void populateGridWithAnimals();
		
	public void createAnimalPane();
	
	public void renderAnimalGrid();

	// best case would return null, but then do I need to make them all instance vars in SLogoView?
	public HBox createConsole();
	public TextArea createConsoleArea();


}
