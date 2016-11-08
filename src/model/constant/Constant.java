package model.constant;

/**
 * This is the Command class, which is a data structure that stores the value of a constant if the user enters a number as a 
 * parameter.
 * 
 * @author Aninda Manocha
 */

public class Constant {
	private double value;
	
	public Constant() {
		this.value = 0;
	}
	
	public Constant(double value) {
		this.value = value;
	}
	
	/*****GETTER*****/
	
	public double getValue() {
		return value;
	}
	
	/*****SETTER*****/
	
	public void setValue(double value) {
		this.value = value;
	}
}