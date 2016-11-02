package model.variable;

public class Variable {
	private String name;
	private double value;
	private boolean local;
	
	public Variable() {
		name = "";
		value = 0;
		local = false;
	}
	
	public Variable(String name, boolean local) {
		this.name = name;
		this.value = 0;
		this.local = local;
	}
	
	public Variable(String name, double value, boolean local) {
		this.name = name;
		this.value = value;
		this.local = local;
	}
	
	/*****GETTERS*****/
	
	public String getName() {
		return name;
	}
	
	public double getValue() {
		return value;
	}
	
	public boolean isLocal() {
		return local;
	}
	
	/*****SETTERS*****/
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public void setLocal(boolean local) {
		this.local = local;
	}
}