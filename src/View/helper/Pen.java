package View.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import View.tabs.OptionsPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Pen implements Observer {
	
//	private Line line;
	private List<Line> lineList;
	private int counter;
	private String color;
	
	public Pen() {
		counter = 0;
		lineList = new ArrayList<>();
//		line = new Line();
//		line.setFill(Color.BLACK);
	}
	
	public Pen(double x, double y){
		counter = 0;
		lineList = new ArrayList<>();
//		line = new Line(x, y, x, y);
//		line.setFill(Color.BLACK);
	}
	
	public void createLine(double x, double y) {
		Line line = new Line(x, y, x, y);
		line.setFill(Color.web("#00FF00"));
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
	
	public List<Line> getLineList() {
		return lineList;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof PenColor) {
			color = ((PenColor) o).getComboBox().getValue();
		}
		
	}
	
}
