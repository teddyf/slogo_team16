package Animals;
import slogo_team16.Graphics;
import javafx.scene.image.Image;

public class Turtle extends Animal {
	private double width;
	private double height;
	private Image turtleAppearance;
	private Graphics graphic = new Graphics();
	
	public Turtle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
		turtleAppearance = graphic.createImage("turtleLogo.png");
	}
	
	public Turtle(double width, double height, double x, double y) {
		super(x, y);
		this.width = width;
		this.height = height;
		turtleAppearance = graphic.createImage("turtleLogo.png");
	}
	
	public Image getTurtleImage(){
		return turtleAppearance;
	}
	
	@Override
	public void update() {
		
	}
	
	/*****GETTERS*****/
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public Image getImage() {
		return turtleAppearance;
	}
}
