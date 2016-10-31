package model.animal;

import View.helper.Graphics;
import View.helper.Pen;
import View.helper.PenContainer;
import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
		
		/*
		//testing gif
		AnimatedAnimal animal = new AnimatedAnimal();
		animalGif=animal.getAnimation();
		*/
//		penColor = new PenColor();
		actualPen = new Pen(getX(), getY(), penColor);
//		penColor.addObserver(actualPen);
//		actualPen.getLine().endXProperty().bind(this.getImageView().translateXProperty());
//		actualPen.getLine().endYProperty().bind(this.getImageView().translateYProperty());

	}
	
	@Deprecated
	public Turtle(double width, double height) {
		super(width, height);
		setImagePath("turtleLogo.png");
		turtleAppearance = graphic.createImage(imagePath);
		setImageView(new ImageView(turtleAppearance));
		turtleImageView = graphic.createImageView(turtleAppearance);
		/*
		AnimatedAnimal animal = new AnimatedAnimal();
		animalGif=animal.getAnimation();
		*/
//		penColor = new PenColor();
		actualPen = new Pen(getX(), getY());
//		penColor.addObserver(actualPen);
//		actualPen.getLine().endXProperty().bind(this.getImageView().translateXProperty());
//		actualPen.getLine().endYProperty().bind(this.getImageView().translateYProperty());

	}

	@Deprecated
	public Turtle(double width, double height, double x, double y) {
		super(width, height, x, y);
		setImagePath("turtleLogo.png");
		turtleAppearance = graphic.createImage(imagePath);
		setImageView(new ImageView(turtleAppearance));
		turtleImageView = graphic.createImageView(turtleAppearance);
		/*
		AnimatedAnimal animal = new AnimatedAnimal();
		animalGif=animal.getAnimation();
		*/
//		penColor = new PenColor();
		actualPen = new Pen(getX(), getY());
//		penColor.addObserver(actualPen);
//		actualPen.getLine().endXProperty().bind(this.getImageView().translateXProperty());
//		actualPen.getLine().endYProperty().bind(this.getImageView().translateYProperty());

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
	}
	
	@Override
	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}

	@Override
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
