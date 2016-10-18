package Model.animal;
import View.helper.Graphics;
import View.helper.Pen;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Turtle extends Animal {
	private Image turtleAppearance;
	private ImageView turtleImageView;
	private Graphics graphic = new Graphics();
	private Pen actualPen;

	private String imagePath;
	
	
	
	public Turtle() {
		super();
		setImagePath("turtleLogo.png");
		turtleAppearance = graphic.createImage(imagePath);
		turtleImageView = graphic.createImageView(turtleAppearance);
		
		actualPen = new Pen(getX(), getY());
//		actualPen.getLine().endXProperty().bind(this.getImageView().translateXProperty());
//		actualPen.getLine().endYProperty().bind(this.getImageView().translateYProperty());

	}
	
	public Turtle(double width, double height) {
		super(width, height);
		setImagePath("turtleLogo.png");
		turtleAppearance = graphic.createImage(imagePath);
		turtleImageView = graphic.createImageView(turtleAppearance);
		
		actualPen = new Pen(getX(), getY());
//		actualPen.getLine().endXProperty().bind(this.getImageView().translateXProperty());
//		actualPen.getLine().endYProperty().bind(this.getImageView().translateYProperty());

	}
	
	public Turtle(double width, double height, double x, double y) {
		super(width, height, x, y);
		setImagePath("turtleLogo.png");
		turtleAppearance = graphic.createImage(imagePath);
		turtleImageView = graphic.createImageView(turtleAppearance);
		
		actualPen = new Pen(getX(), getY());
//		actualPen.getLine().endXProperty().bind(this.getImageView().translateXProperty());
//		actualPen.getLine().endYProperty().bind(this.getImageView().translateYProperty());

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
	
	@Override
	public Pen getActualPen() {
		return actualPen;
	}
}
