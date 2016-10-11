package Animals;
import slogo_team16.Graphics;
import javafx.scene.image.Image;

public class Turtle extends Animal {
	private Image turtleAppearance;
	private Graphics graphic = new Graphics();
	
	public Turtle(double width, double height) {
		super(width, height);
		turtleAppearance = graphic.createImage("turtleLogo.png");
	}
	
	public Turtle(double width, double height, double x, double y) {
		super(width, height, x, y);
		turtleAppearance = graphic.createImage("turtleLogo.png");
	}
	
	@Override
	public void update() {
		
	}
	
	/*****GETTERS*****/
	
	public Image getImage() {
		return turtleAppearance;
	}
}
