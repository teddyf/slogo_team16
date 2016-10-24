package model.animal;

import View.AnimatedGif.AnimatedAnimal;
import View.helper.Graphics;
import View.helper.Pen;
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
	
	
	
	public Turtle() {
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
		
		actualPen = new Pen(getX(), getY());
//		actualPen.getLine().endXProperty().bind(this.getImageView().translateXProperty());
//		actualPen.getLine().endYProperty().bind(this.getImageView().translateYProperty());

	}
	
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
		actualPen = new Pen(getX(), getY());
//		actualPen.getLine().endXProperty().bind(this.getImageView().translateXProperty());
//		actualPen.getLine().endYProperty().bind(this.getImageView().translateYProperty());

	}

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
		actualPen = new Pen(getX(), getY());
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
