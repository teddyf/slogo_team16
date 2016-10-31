package View.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import Controller.Data;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
/**
 * 
 * @author Jordan Frazier
 *
 */
public class Pen implements Observer {
	
	private Line line;
	private List<Line> lineList;
	private int counter;
	private String color;
	private double strokeWidth;
	private double dashValue;
	
	private static final String PEN_COLOR = "Pen Color: ";
	private static final String PEN_WIDTH = "Pen Width: ";
	private static final String PEN_DASH = "Pen Dash: ";
	
	public Pen() {
		initializeVariables();
		color = decodeColor(Colors.BLACK.getAllColors()[0]);
		
//		line = new Line();
//		line.setFill(Color.BLACK);
	}
	
	public Pen(double x, double y){
		initializeVariables();
		color = decodeColor(Colors.BLACK.getAllColors()[0]);
//		line = new Line(x, y, x, y);
//		line.setFill(Color.BLACK);
	}
	
	public Pen(double x, double y, PenContainer penColor) {
		initializeVariables();
		color = penColor.getComboBox().getValue();
	}

	private void initializeVariables() {
		counter = 0;
		lineList = new ArrayList<>();
		strokeWidth = Data.getInstance().getPenSize();
		dashValue = Data.getInstance().getDashValue();
	}
	
	public void createLine(double x, double y) {
		Line line = new Line(x, y, x, y);
		line.setStroke(Color.web(color));
		line.setStrokeWidth(strokeWidth);
		line.getStrokeDashArray().add(dashValue);
		
		lineList.add(line);
		
	}

//	@Override
//	public void update(Observable o, Object arg) {
//		System.out.println("PEN IS OBSERVING");
//		if (o instanceof Animal) {
//			line.setEndX(((Animal) o).getX());
//			line.setEndX(((Animal) o).getY());
//		}
//	}
//	
//	public Line getLine() {
//		return line;
//	}
	
	public int getCounter() {
		return counter;
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

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof PenContainer) {
			// TODO: convert string to hex
			color = decodeColor(((PenContainer) o).getComboBox().getValue());
			strokeWidth = Data.getInstance().getPenSize();
			dashValue = Data.getInstance().getDashValue();
		}
	}
	
	public String decodeColor(String color) { 
		return Colors.BLACK.getColorMap().get(color);
//		for(Colors c : Colors.values()) {
//			if(c.toString().equals(color)) {
//				return c.getHexColor();
//			}
//		}
//		return null;
	}
	
}
