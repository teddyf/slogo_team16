package View;

import java.util.List;

import View.helper.Graphics;
import model.animal.Animal;

public class AnimalClick {

	private String WEIRDTURTLE = "http://images.clipartpanda.com/turtle-clip-art-turtle6.png";

	private String DEADTURTLE = "http://vignette4.wikia.nocookie.net/penguindrum/images/e/ee/Mawaru_penguindrum_peng_head_by_gintabro-d3lj8vt.png/revision/latest?cb=20120304141806";

	private Graphics graphic = new Graphics();
	private List<Animal> activeTurtles; 
	private AnimalPaneGUI animalPane;

	public AnimalClick(AnimalPaneGUI animalPane) {
		this.animalPane = animalPane;
	}
	
	public AnimalClick() {
		
	}
	
	public void setWeirdTurtle(String url){
		WEIRDTURTLE = url;
	}
	
	public void setDeadTurtle(String url){
		DEADTURTLE = url;
	}

	public void setEventListener(Animal animal) {
		animal.getImageView().setOnMouseClicked(event -> {
			updateAnimal(animal);
		});
	}

	private void updateAnimal(Animal animal) {
		if (animal.getSelected()) { // it's already active, so deactivate it
			animal.setSelected(false);
			animal.getImageView().setStyle("-fx-image: url(\"" + DEADTURTLE + "\");");
		} else {
			animal.setSelected(true);
			animal.getImageView().setStyle("-fx-image: url(\"" + WEIRDTURTLE + "\");");
		}
	}

	public List<Animal> getActiveTurtles() {
		return activeTurtles;
	}

	public void setActiveTurtles(List<Animal> activeTurtles) {
		this.activeTurtles = activeTurtles;
	}

	public boolean isActiveAnimal(Animal animal) {
		return (activeTurtles.contains(animal));
	}
}
