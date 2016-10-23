package Model.animal;

import View.helper.Graphics;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Turtle extends Animal {
	private Graphics graphic = new Graphics();
	private Image turtleAppearance;
	private ImageView imageView;
	private String imagePath;

	public Turtle() {
		super();
		setImagePath("turtleLogo.png");
		turtleAppearance = graphic.createImage(imagePath);
		setImageView(new ImageView(turtleAppearance));
	}
	
	public Turtle(double width, double height) {
		super(width, height);
		setImagePath("turtleLogo.png");
		turtleAppearance = graphic.createImage(imagePath);
		setImageView(new ImageView(turtleAppearance));
	}

	public Turtle(double width, double height, double x, double y) {
		super(width, height, x, y);
		setImagePath("turtleLogo.png");
		turtleAppearance = graphic.createImage(imagePath);
		setImageView(new ImageView(turtleAppearance));
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
