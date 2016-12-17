package View.image_helper;

import java.io.File;
import java.io.FileNotFoundException;

import Controller.Controller;
import View.AnimalPaneGUI;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.animal.Animal;

public class ImageChooser {

	private AnimalPaneGUI myAnimalPane;
	private FileLoader myFileLoader;
	private Button button;
	private ImageView clone;

	public ImageChooser(Controller controller) {
		myAnimalPane = controller.getActiveAnimalPaneGUI();
		// myImageView = animalPane.getImageView();
		myFileLoader = new FileLoader();
		createButton();
	}

	private void createButton() {
		button = new Button("Select Turtle Image");
		button.setOnAction(e -> {
			createStage();
		});
	}

	private void createStage() {
		Stage stage = new Stage();
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 800, 600);

		addAnimals(pane);

		stage.setScene(scene);
		stage.showAndWait();

	}

	private void addAnimals(Pane pane) {
//		List<ImageView> imageList = myAnimalPane.getMyAnimalList().stream().map(e -> e.getImageView())
//				.collect(Collectors.toList());
//		imageList.forEach(e -> {
//			pane.getChildren().add(e);
//			e.setOnMouseClicked(event -> {
//				openImageSelector(e);
//			});
//		});
		
		myAnimalPane.getMyAnimalList().forEach(e -> {
			clone = new ImageView(e.getImage());
			clone.setFitHeight(15);
			clone.setFitWidth(15);
			clone.setLayoutX(e.getX());
			clone.setLayoutY(e.getY());

			pane.getChildren().add(clone);
			clone.setOnMouseClicked(event -> {
				openImageSelector(e);
			});
		});
	}
	
	

	private void openImageSelector(Animal animal) {
		File file;
		try {
			file = myFileLoader.loadSingle();
			
			clone.setImage(new Image(file.toURI().toString()));
			myAnimalPane.getMyContainer().getChildren().remove(animal.getImageView());

			animal.setImage(new Image(file.toURI().toString()));
			animal.setImageView(new ImageView(animal.getImage()));

			addAnimalToGrid(animal);
		} catch (FileNotFoundException e) {
			// Do Nothing
			return;
		}
	}

	public Button getButton() {
		return button;
	}
	
	private void addAnimalToGrid(Animal animal) {
		ImageView animalImage = animal.getImageView();
		animalImage.setFitHeight(15);
		animalImage.setFitWidth(15);
		animalImage.setTranslateX(animal.getX());
		animalImage.setTranslateY(animal.getY());

		if (!myAnimalPane.getMyContainer().getChildren().contains(animalImage)) {
			myAnimalPane.getMyContainer().getChildren().add(animalImage);
		}

		myAnimalPane.getScrollPane().setContent(myAnimalPane.getMyContainer());
	}
}
