package View;

import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.Main;

import java.io.File;
import java.util.HashMap;
import java.util.ResourceBundle;

import Controller.DataSetup.DataSetup;

public class HomeSelection {
	private final File INITIAL_DIRECTORY = new File("data");
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
		createFileDirectory();
	}

	/**
	 * @return the file name
	 */
	public String getFileName() {
		return fileName;
	}

	private void createFileDirectory() {
		FileChooser chooser = new FileChooser();
		chooser.setInitialDirectory(INITIAL_DIRECTORY);
		chooser.setTitle("Choose File");
		File temp = chooser.showOpenDialog(new Stage());
		if (temp != null) {
			System.out.println("Here is temp: ");
			System.out.println(temp.toString());
			fileName = temp.toString();
			data = new DataSetup(fileName);
			createWorkspaceFromXML(fileName);
			System.out.println("Data: " + data);
			System.out.println(fileName);
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
		System.out.println(generalInfo);
		return null;
	}
}
