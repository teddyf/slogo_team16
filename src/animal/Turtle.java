package animal;
import View.Graphics;
import javafx.scene.image.Image;

public class Turtle extends Animal {
	private Image turtleAppearance;
	private Graphics graphic = new Graphics();
	
	private String imagePath;
	
	public Turtle(double width, double height) {
		super(width, height);
		turtleAppearance = graphic.createImage(imagePath);
	}
	
	public Turtle(double width, double height, double x, double y) {
		super(width, height, x, y);
		turtleAppearance = graphic.createImage(imagePath);
	}
	
	@Override
	public void update() {
		
	}
	
	/*****GETTERS*****/
	
	public Image getImage() {
		return turtleAppearance;
	}

	@Override
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
