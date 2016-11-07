package View.helper;
/**
 * This class is used as the data structure that holds points a turtle should animate to. 
 * It is sent from the backend to the AnimalPane in a map of ID's to Coordinates. 
 * @author Jordan Frazier
 *
 */
public class Coordinate {
	
	private double x;
	private double y;
	private double heading;
	private double pen;
	private double showing;
	
	public Coordinate(double x, double y, double heading, double pen, double showing) {
		this.x = x;
		this.y = y;	
		this.heading = heading;
		this.pen = pen;
		this.showing = showing;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public double getHeading() {
		return heading;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public void setHeading(double heading) {
		this.heading = heading;
	}

	public double getPen() {
		return pen;
	}

	public double getShowing() {
		return showing;
	}

	public void setPen(int pen) {
		this.pen = pen;
	}

	public void setShowing(int showing) {
		this.showing = showing;
	}

}
