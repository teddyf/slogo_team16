package model.command;

import model.animal.Animal;

public class Parameter {
	private Animal turtle;
	private String name;
	private double value;
	private Object[] list;
	
	public Parameter() {
		this.turtle = null;
		this.name = null;
		this.value = 0;
		this.list = null;
	}
	
	public Parameter(Animal turtle) {
		this.turtle = turtle;
		this.name = null;
		this.value = 0;
		this.list = null;
	}
	
	public Parameter(String name) {
		this.turtle = null;
		this.name = name;
		this.value = 0;
		this.list = null;
	}
	
	public Parameter(double value) {
		this.turtle = null;
		this.name = null;
		this.value = value;
		this.list = null;
	}
	
	public Parameter(Object[] list) {
		this.turtle = null;
		this.name = null;
		this.value = 0;
		this.list = list;
	}
	
	/*****GETTERS*****/
	
	public Animal getAnimal() {
		return turtle;
	}
	
	public String getName() {
		return name;
	}
	
	public double getValue() {
		return value;
	}
	
	public Object[] getList() {
		return list;
	}
	
	/*****SETTERS*****/
	
	public void setAnimal(Animal turtle) {
		this.turtle = turtle;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public void setList(Object[] list) {
		this.list = list;
	}
}
