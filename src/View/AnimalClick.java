package View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import View.helper.Graphics;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.animal.Animal;

public class AnimalClick {

	public static final String WEIRDTURTLE="http://images.clipartpanda.com/turtle-clip-art-turtle6.png";
	
	public static final String DEADTURTLE = "http://vignette4.wikia.nocookie.net/penguindrum/images/e/ee/Mawaru_penguindrum_peng_head_by_gintabro-d3lj8vt.png/revision/latest?cb=20120304141806";
	//private Map<Animal, String> activeTurtles = new HashMap<Animal, String>();
	private Graphics graphic = new Graphics(); 
	private ArrayList<Animal> activeTurtles = new ArrayList<Animal>();

	public AnimalClick() {
	}

	public void setEventListener(Animal animal) {
		animal.getImageView().setOnMouseClicked(event -> {
			updateAnimal(animal);
			System.out.println("Clicked! Active animals: ");
			System.out.println(activeTurtles);
		});
	}
	
	private void setActiveAnimal(Animal animal){
		activeTurtles.add(animal);
	}
	
	private void updateAnimal(Animal animal){
		if (isActiveAnimal(animal)){ //it's already active, so deactivate it
			activeTurtles.remove(animal);
			animal.getImageView().setStyle("-fx-image: url(\""+ DEADTURTLE + "\");");
		}else{
			setActiveAnimal(animal);
			animal.getImageView().setStyle("-fx-image: url(\""+ WEIRDTURTLE + "\");");
			//setNewImage("turtleLogo.png",animal);
		}
		//animal.getImageView().setStyle("-fx-image: url(\""+ imageUrl + "\");");
	}
	
	private void setNewImage(String url, Animal animal){
		animal.setImageView(null);
		animal.setImage(new Image(url));
		Image turtleAppearance = graphic.createImage(url);
		ImageView turtleImageView = graphic.createImageView(turtleAppearance);
		System.out.println("Imageview: "+turtleImageView);
		animal.setImageView(turtleImageView);
	}
	
	public boolean isActiveAnimal(Animal animal){
		return (activeTurtles.contains(animal));
	}
}
