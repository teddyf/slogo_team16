package slogo_team16;

import javafx.scene.image.Image;

public class Turtle {
	private int x;
	private int y;
	private Image turtleAppearance;
	private Graphics graphic = new Graphics();
	
	public Turtle(int x, int y){
		this.x = x;
		this.y = y;
		turtleAppearance = graphic.createImage("turtleLogo.png");
	}
	
	public Image getTurtleImage(){
		return turtleAppearance;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void updateTurtle(){
	
	}

	

}
