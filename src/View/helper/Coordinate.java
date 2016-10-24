package View.helper;

public class Coordinate {
	
	private double x;
	private double y;
	private double heading;
	
	public Coordinate(double x, double y, double heading) {
		this.x = x;
		this.y = y;	
		this.heading = heading;
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

}
