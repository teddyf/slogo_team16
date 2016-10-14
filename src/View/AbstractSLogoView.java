package View;

import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;

public interface AbstractSLogoView {
	
	static final int SCENE_WIDTH = 1200;
	static final int SCENE_HEIGHT = 700;
	static final int LEFT_PANE_WIDTH = SCENE_WIDTH - SCENE_WIDTH / 3;
	static final int RIGHT_PANE_WIDTH = SCENE_WIDTH / 3 - 30;
	
	public Scene init();
	
	//I have literally no idea what this does lol
	public <T> ComboBox<? extends T> createLanguageChooser();
	
	public void populateGridWithAnimals();
		
	public void createAnimalGrid();
	
	public void renderAnimalGrid();

	// best case would return null, but then do I need to make them all instance vars in SLogoView?
	public HBox createConsole();
	public TextArea createConsoleArea();


}
