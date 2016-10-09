package Animals;
import slogo_team16.Graphics;
import javafx.scene.image.Image;

public class Turtle extends Animal {
	private Image turtleAppearance;
	private Graphics graphic = new Graphics();
	
	public Turtle(double x, double y){
		super(x, y);
		turtleAppearance = graphic.createImage("turtleLogo.png");
	}
	
	public Turtle(double x, double y, double width, double height){
		super(x, y, width, height);
		turtleAppearance = graphic.createImage("turtleLogo.png");
	}
	
	public Image getTurtleImage(){
		return turtleAppearance;
	}
	
	@Override
	public void update() {
		
	}	

}
