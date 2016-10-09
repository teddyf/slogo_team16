package Animals;

import javafx.scene.image.ImageView;
import slogo_team16.Graphics;

public abstract class Animal {
	private double x;
	private double y;
	private double width;
	private double height;

	private ImageView image;
	private Graphics graphic = new Graphics();

	public Animal(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Animal(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public ImageView getImage() {
		return image;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public abstract void update();

}