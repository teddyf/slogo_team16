package Model.animal;

import java.util.Observable;

import View.Workspace;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

/**
 * @author Aninda Manocha, Teddy Franceschi
 */

public abstract class Animal extends Observable {
	private double width;
	private double height;
	private double x;
	private double y;
	private StringProperty xProperty;
	private StringProperty yProperty;
	private double heading;
	private int pen; 
	private int showing;
	private int ID;
	// Used when multiple turtles are on the same screen, and if user only wants to move a certain animal
	private boolean isSelected;

	public Animal(double width, double height) {
		xProperty = new SimpleStringProperty();
		yProperty = new SimpleStringProperty();
		this.width = width;
		this.height = height;
		setX(Workspace.SCENE_WIDTH/2);
		setY(Workspace.SCENE_HEIGHT/2);
		this.heading = 0;
		this.pen = 0;
		this.showing = 1;
		this.ID = -1;
		this.isSelected = true;
	}
	
	public Animal(double width, double height, double x, double y) {
		xProperty = new SimpleStringProperty();
		yProperty = new SimpleStringProperty();
		this.width = width;
		this.height = height;
		setX(x);
		setY(y);
		this.heading = 0;
		this.pen = 0;
		this.showing = 1;
	}

	/**
	 * Moves the animal forward in its current heading by a specified number of pixels
	 * @param pixels - the specified number of pixels
	 * @return the number of pixels
	 */
	public double forward(double pixels) {
		double angle = 90 - heading;
		setX(getX() + Math.cos(angle)*pixels);
		setY(getY() - Math.sin(angle)*pixels);
		return pixels;
	}
		
	/**
	 * Moves the animal backward in its current heading by a specified number of pixels
	 * @param pixels - the specified number of pixels
	 * @return the number of pixels 
	 */
	public double back(double pixels) {
		forward(pixels*-1);
		return pixels;
	}

	/**
	 * Turns the animal counterclockwise by a specified number of degrees
	 * @param degrees - the specified number of degrees
	 * @return the number of degrees
	 */
	public double right(double degrees) {
		heading += degrees;
		heading = heading % 360;
		return degrees;
	}
		
	/**
	 * Turns the animal clockwise by a specified number of degrees
	 * @param degrees - the specified number of degrees
	 * @return the number of degrees
	 */
	public double left(double degrees) {
		right(degrees*-1);
		if (heading < 0) {
			heading = 360 - heading;
		}
		return degrees;
	}
		
	/**
	 * Turns the animal to an absolute heading
	 * @param heading - the absolute heading
	 * @return the number of degrees moved
	 */
	public double setHeading(double heading) {
		if (Math.abs(this.heading - heading) <= 180) {
			this.heading = heading % 360;
			return Math.abs(this.heading - heading);
		} else {
			this.heading = heading % 360;
			return 360 - Math.abs(this.heading - heading);
		}
	}
		
	/**
	 * Moves the animal to an absolute screen position
	 * @param x - the specified x coordinate
	 * @param y - the specified y coordinate
	 * @return the distance the turtle moved
	 */
	public double setXY(double x, double y) {
		double distance = Math.sqrt(Math.pow(this.x-x, 2) + Math.pow(this.y-y, 2));
		this.x = x + Workspace.SCENE_WIDTH/2;
		this.y = Workspace.SCENE_HEIGHT/2 - y;
		return distance;
	}
		
	/**
	 * Puts pen down so that the animal leaves a trail when it moves
	 * @return 1
	 */
	public int penDown() {
		this.pen = 1;
		return this.pen;
	}
		
	/**
	 * Puts pen up so that the animal doesn't leave a trail when it moves
	 * @return
	 */
	public int penUp() {
		this.pen = 0;
		return this.pen;
	}
		
	/**
	 * Makes the animal visible
	 * @return 1
	 */
	public int showTurtle() {
		this.showing = 1;
		return this.showing;
	}
		
	/**
	 * Makes the animal invisible
	 * @return 0
	 */
	public int hideTurtle() {
		this.showing = 0;
		return this.showing;
	}
		
	/**
	 * Moves the animal to the center of the screen
	 * @return the distance the turtle moved
	 */
	public double home() {
		double distance = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
		this.x = 0;
		this.y = 0;
		return distance;
	}
		
	/**
	 * Erases the animal's trails and places it at the center of the screen
	 * @return the distance the turtle moved
	 */
	public double clearScreen() {
		return home();
	}
			
	/*****GETTERS*****/
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
		
	public double getHeading() {
		return heading; //in degrees
	}
		
	public int getPenDown() {
		return pen; //1 if pen down, 0 if pen up
	}
		
	public int getShowing() {
		return showing;
	}
		
	public StringProperty getXProperty() {
		return xProperty;
	}

	public StringProperty getYProperty() {
		return yProperty;
	}
	
	public int getId() {
		return ID;
	}
	
	public boolean getSelected() {
		return isSelected;
	}

	/*****SETTERS*****/
	
	public void setX(double x) {
		this.x = x;
		this.xProperty.setValue(String.valueOf(x));
		setChanged();
		notifyObservers();
	}

	public void setY(double y) {
		this.y = y;
		this.yProperty.setValue(String.valueOf(y));
		setChanged();
		notifyObservers();
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
		
	public void setPen(int pen) {
		this.pen = pen;
	}
		
	public void setShowing(int showing) {
		this.showing = showing;
	}
	
	public void setId(int ID) {
		this.ID = ID;
	}
	
	public void setSelected(boolean isSelected) {
		 this.isSelected = isSelected;
	}

	public abstract void update();
	
	public abstract void setImagePath(String imagePath);
	
	public abstract Image getImage();

}