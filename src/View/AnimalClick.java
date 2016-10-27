package View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.ImageView;
import model.animal.Animal;

public class AnimalClick {

	public static final String WEIRDTURTLE="http://www.wildlifedepartment.com/wildlifemgmt/turtles/Common%20Map%20Turtle.jpg";
	//private Map<Animal, String> activeTurtles = new HashMap<Animal, String>();
	
	private ArrayList<Animal> activeTurtles = new ArrayList<Animal>();

	public AnimalClick() {
	}

	public void setEventListener(Animal animal) {
		animal.getImageView().setOnMouseClicked(event -> {
			setActiveAnimal(animal);
			changeToActiveImage(animal.getImageView(), WEIRDTURTLE);
			System.out.println("Clicked! Active animals: ");
			System.out.println(activeTurtles);
		});
	}
	
	private void setActiveAnimal(Animal animal){
		activeTurtles.add(animal);
	}
	
	private void changeToActiveImage(ImageView image, String imageUrl){
		image.setStyle("-fx-image: url(\""+ imageUrl + "\");");
	}
}
