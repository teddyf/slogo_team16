package model.animal;

import java.util.Observable;

import View.Workspace;
import View.helper.Pen;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
	private double pen;
	private double showing;
	private int ID;
	// Used when multiple turtles are on the same screen, and if user only wants to move a certain animal
	private boolean isSelected;

	public Animal() {
		xProperty = new SimpleStringProperty();
		yProperty = new SimpleStringProperty();
		this.width = 15;
		this.height = 15;
		this.x = Workspace.LEFT_PANE_WIDTH / 2;
		this.y = Workspace.LEFT_PANE_HEIGHT / 2;
		this.heading = 0;
		this.pen = 0;
		this.showing = 1;
		this.ID = -1;
		this.isSelected = true;
	}
	
	public Animal(double width, double height) {
		xProperty = new SimpleStringProperty();
		yProperty = new SimpleStringProperty();
		this.width = width;
		this.height = height;
		this.x = Workspace.SCENE_WIDTH / 2;
		this.y = Workspace.SCENE_HEIGHT / 2;
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
		this.x = Workspace.SCENE_WIDTH / 2 + x;
		this.y = Workspace.SCENE_HEIGHT / 2 - y;
		this.heading = 0;
		this.pen = 0;
		this.showing = 1;
	}

	public abstract void update();

	/***** GETTERS *****/

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
		return heading; // in degrees
	}

	public double getPen() {
		return pen; // 1 if pen down, 0 if pen up
	}

	public double getShowing() {
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

	public abstract Image getImage();
	
	public abstract ImageView getImageView();

	public abstract String getImagePath();

	/***** SETTERS *****/

	public void setWidth(double width) {
		this.width = width;
	}

	public void setHeight(double height) {
		this.height = height;
	}

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

	public void setHeading(double heading) {
		this.heading = heading;
	}

	public void setPen(double pen) {
		this.pen = pen;
	}

	public void setShowing(double showing) {
		this.showing = showing;
	}

	public void setId(int ID) {
		this.ID = ID;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public abstract void setImage(Image image);
	
	public abstract void setImageView(ImageView imageView);

	public abstract void setImagePath(String imagePath);
	
	public abstract Pen getActualPen();
}