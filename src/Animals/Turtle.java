package Animals;
import slogo_team16.Graphics;
import javafx.scene.image.Image;

public class Turtle {
	private double x;
	private double y;
	private double heading;
	private int pen; 
	private int showing;
	private Image turtleAppearance;
	private Graphics graphic = new Graphics();
	
	public Turtle(){
		this.x = 0;
		this.y = 0;
		this.heading = 0;
		this.pen = 0;
		this.showing = 1;
		this.turtleAppearance = graphic.createImage("turtleLogo.png");
	}
	
	/**
	 * Moves the turtle forward in its current heading by a specified number of pixels
	 * @param pixels - the specified number of pixels
	 * @return the number of pixels
	 */
	public double forward(double pixels) {
		double angle = 90 - heading;
		x += Math.cos(angle)*pixels;
		y += Math.sin(angle)*pixels;
		return pixels;
	}
	
	/**
	 * Moves the turtle backward in its current heading by a specified number of pixels
	 * @param pixels - the specified number of pixels
	 * @return the number of pixels 
	 */
	public double back(double pixels) {
		forward(pixels*-1);
		return pixels;
	}
	
	/**
	 * Turns the turtle counterclockwise by a specified number of degrees
	 * @param degrees - the specified number of degrees
	 * @return the number of degrees
	 */
	public double right(double degrees) {
		heading += degrees;
		heading = heading % 360;
		return degrees;
	}
	
	/**
	 * Turns the turtle clockwise by a specified number of degrees
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
	 * Turns the turtle to an absolute heading
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
	 * Moves the turtle to an absolute screen position
	 * @param x - the specified x coordinate
	 * @param y - the specified y coordinate
	 * @return the distance the turtle moved
	 */
	public double setXY(double x, double y) {
		double distance = Math.sqrt(Math.pow(this.x-x, 2) + Math.pow(this.y-y, 2));
		this.x = x;
		this.y = y;
		return distance;
	}
	
	/**
	 * Puts pen down so that the turtle leaves a trail when it moves
	 * @return 1
	 */
	public int penDown() {
		this.pen = 1;
		return this.pen;
	}
	
	/**
	 * Puts pen up so that the turtle doesn't leave a trail when it moves
	 * @return
	 */
	public int penUp() {
		this.pen = 0;
		return this.pen;
	}
	
	/**
	 * Makes the turtle visible
	 * @return 1
	 */
	public int showTurtle() {
		this.showing = 1;
		return this.showing;
	}
	
	/**
	 * Makes the turtle invisible
	 * @return 0
	 */
	public int hideTurtle() {
		this.showing = 0;
		return this.showing;
	}
	
	/**
	 * Moves the turtle to the center of the screen
	 * @return the distance the turtle moved
	 */
	public double home() {
		double distance = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
		this.x = 0;
		this.y = 0;
		return distance;
	}
	
	/**
	 * Erases the turtle's trails and places it at the center of the screen
	 * @return the distance the turtle moved
	 */
	public double clearScreen() {
		return home();
	}
	
	public void updateTurtle() {
		
	}

	/*****GETTERS*****/
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
	
	public Image getTurtleImage(){
		return turtleAppearance;
	}
	
	/*****SETTERS*****/
	
	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public void setPen(int pen) {
		this.pen = pen;
	}
	
	public void setShowing(int showing) {
		this.showing = showing;
	}
}
