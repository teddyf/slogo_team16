package View;

import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.Main;

import java.io.File;
import java.util.HashMap;
import java.util.ResourceBundle;

import Controller.DataSetup.DataSetup;
/**
 * This class takes care of opening a computer's file chooser on the initial run of the program, and allows the user to
 * choose an xml file for the user to read to create a slogoView based on the file settins
 * @author lucyzhang
 *
 */
public class HomeSelection {
	private final File INITIAL_DIRECTORY = new File("data");
	private final File IMAGE_DIRECTORY = new File("Resources");
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	private String fileName;
	private DataSetup data;
	private SlogoView slogoView;
	private Stage s;
	private ResourceBundle myResources;


	public HomeSelection(Stage s) {
		this.s = s;
	}
	
	public HomeSelection() {
		
	}

	/**
	 * Creates the file directory to choose an xml simulation file to run
	 */
	public void initHomeScreen() {
		createFileDirectory(INITIAL_DIRECTORY);
	}


	/**
	 * @return the file name
	 */
	public String getFileName() {
		return fileName;
	}

	
	public void createFileDirectory(File directory) {
		FileChooser chooser = new FileChooser();
		chooser.setInitialDirectory(directory);
		chooser.setTitle("Choose File");
		File temp = chooser.showOpenDialog(new Stage());
		if (temp != null & directory.equals(INITIAL_DIRECTORY)) {
			fileName = temp.toString();
			data = new DataSetup(fileName);
			createWorkspaceFromXML(fileName);
		}else if (temp != null & directory.equals(IMAGE_DIRECTORY)){
			//TODO: change turtle image
		}
	}

	private Workspace createWorkspaceFromXML(String fileName) {
		DataSetup data = new DataSetup(fileName);
		HashMap<String, String> generalInfo = data.getGeneralInfo();
		slogoView = new SlogoView(generalInfo.get("title"), generalInfo.get("background_color").toUpperCase(),
				generalInfo.get("language"), Integer.parseInt(generalInfo.get("numTurtles")));
		Scene scene = slogoView.init();
		scene.getStylesheets().add(this.getClass().getResource("/main/SLogoStyle.css").toExternalForm());
		s.setTitle(Main.TITLE);
		s.setScene(scene);
		s.show();
		return null;
	}
}
