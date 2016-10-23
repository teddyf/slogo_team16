package model.variable;

public class Variable {
	private String name;
	private double value;
	
	public Variable() {
		name = "";
		value = 0;
	}
	
	public Variable(String name) {
		this.name = name;
		this.value = 0;
	}
	
	public Variable(String name, double value) {
		this.name = name;
		this.value = value;
	}
	
	/*****GETTERS*****/
	
	public String getName() {
		return name;
	}
	
	public double getValue() {
		return value;
	}
	
	/*****SETTERS*****/
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
}