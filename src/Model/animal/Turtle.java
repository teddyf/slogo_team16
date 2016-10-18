package Model.animal;
import View.helper.Graphics;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Turtle extends Animal {
	private Image turtleAppearance;
	private ImageView turtleImageView;
	private Graphics graphic = new Graphics();
	
	private String imagePath;
	
	
	
	public Turtle() {
		super();
		setImagePath("turtleLogo.png");
		turtleAppearance = graphic.createImage(imagePath);
		turtleImageView = graphic.createImageView(turtleAppearance);
	}
	
	public Turtle(double width, double height) {
		super(width, height);
		setImagePath("turtleLogo.png");
		turtleAppearance = graphic.createImage(imagePath);
		turtleImageView = graphic.createImageView(turtleAppearance);
	}
	
	public Turtle(double width, double height, double x, double y) {
		super(width, height, x, y);
		setImagePath("turtleLogo.png");
		turtleAppearance = graphic.createImage(imagePath);
		turtleImageView = graphic.createImageView(turtleAppearance);
	}
	
	@Override
	public void update() {
		// TODO - update turtle
		
		setChanged();
		notifyObservers();
	}
	
	/*****GETTERS*****/
	@Override
	public Image getImage() {
		return turtleAppearance;
	}

	@Override
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	@Override
	public ImageView getImageView() {
		return turtleImageView;
	}
}
