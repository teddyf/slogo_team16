package View.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import Controller.Data;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

//This entire file is part of my masterpiece.
//Jordan Frazier (jrf30)
/**
 * A new Pen instance should be created for every new instance of Animal that is created.
 * The Pen will determine the properties of the line that follows the animal, should
 * the user decide to display the line on the GUI. 
 * This class utilizes a new design pattern, Observer / Observable. When the Data class is 
 * updated, it will trigger the Pen to update its properties accordingly. 
 * @author Jordan Frazier
 *
 */
public class Pen implements Observer {
	
	private List<Line> lineList;
	private String color;
	private double strokeWidth;
	private double dashValue;
	private int counter;
	
	/**
	 * Creates a new Pen, initializes the colors to the current global color setting in Data, and
	 * adds Pen as an Observer of Data
	 */
	public Pen() {
		initializeVariables();
		color = decodeColor(Colors.BLACK.getAllColors()[0]);
		Data.getInstance().addObserver(this);
	}

	@Deprecated
	public Pen(double x, double y){
		initializeVariables();
		color = Data.getInstance().getPenColor();
		Data.getInstance().addObserver(this);
	}

	private void initializeVariables() {
		counter = 0;
		lineList = new ArrayList<>();
		strokeWidth = Data.getInstance().getPenSize();
		dashValue = Data.getInstance().getDashValue();
	}
	
	/**
	 * Creates a new line and adds it to the list of lines
	 * @param x - the x coordinate of the line
	 * @param y - the y coordinate of the line
	 */
	public void createLine(double x, double y) {
		Line line = initializeLineProperties(x, y);
		lineList.add(line);	
	}

	private Line initializeLineProperties(double x, double y) {
		Line line = new Line(x, y, x, y);
		line.setStroke(Color.web(color));
		line.setStrokeWidth(strokeWidth);
		line.getStrokeDashArray().add(dashValue);
		return line;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Data) {
			updatePenProperties();
		}
	}

	private void updatePenProperties() {
		color = Data.getInstance().getPenColor();
		strokeWidth = Data.getInstance().getPenSize();
		dashValue = Data.getInstance().getDashValue();
	}
	
	private String decodeColor(String color) { 
		return Colors.BLACK.getColorMap().get(color);
	}
	
	public void incrementCounter() {
		counter++;
	}
	
	public void resetCounter() {
		counter = 0;
	}
	
	public List<Line> getLineList() {
		return lineList;
	}

	public int getCounter() {
		return counter;
	}
	
}
