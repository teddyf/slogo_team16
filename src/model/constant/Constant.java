package model.constant;

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