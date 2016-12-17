package model.animal;

import View.helper.Graphics;
import View.helper.Pen;
import View.helper.PenContainer;
import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This is the Turtle class, which extends the Animal class, but contains an image for the turtle

 * 
 * @author Aninda Manocha
 * @author Teddy Franceschi
 * @author Jordan Frazier
 */
public class Turtle extends Animal {
	private ImageView turtleImageView;
	private Graphics graphic = new Graphics();
	private Image turtleAppearance;
	private Pen actualPen;
	private ImageView imageView;
	private String imagePath;
	private Animation animalGif;
	
	public Turtle(PenContainer penColor) {
		super();
		setImagePath("turtleLogo.png");
		turtleAppearance = graphic.createImage(imagePath);
		setImageView(new ImageView(turtleAppearance));
		turtleImageView = graphic.createImageView(turtleAppearance);	
		actualPen = new Pen(getX(), getY());
	}
	
	@Deprecated
	public Turtle(double width, double height) {
		super(width, height);
		setImagePath("turtleLogo.png");
		turtleAppearance = graphic.createImage(imagePath);
		setImageView(new ImageView(turtleAppearance));
		turtleImageView = graphic.createImageView(turtleAppearance);
		actualPen = new Pen(getX(), getY());
	}

	@Deprecated
	public Turtle(double width, double height, double x, double y) {
		super(width, height, x, y);
		setImagePath("turtleLogo.png");
		turtleAppearance = graphic.createImage(imagePath);
		setImageView(new ImageView(turtleAppearance));
		turtleImageView = graphic.createImageView(turtleAppearance);
		actualPen = new Pen(getX(), getY());
	}

	public Animation getGif(){
		return animalGif;
	}
	@Override
	public void update() {
		// TODO - update turtle

		setChanged();
		notifyObservers();
	}
	

	/***** GETTERS *****/
	@Override
	public Image getImage() {
		return turtleAppearance;
	}
	
	@Override
	public ImageView getImageView() {
		return imageView;
	}

	@Override
	public String getImagePath() {
		return imagePath;
	}
	
	@Override
	public Pen getActualPen() {
		return actualPen;
	}

	/***** SETTERS *****/

	@Override
	public void setImage(Image image) {
		this.turtleAppearance = image;
		notifyObservers();
	}
	
	@Override
	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
		notifyObservers();
	}

	@Override
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
