package model.command;

import model.animal.Animal;

public class Parameter {
	private Animal turtle;
	private String name;
	private double value;
	private Command[] commands;
	private Parameter[][] params;
	
	public Parameter() {
		this.turtle = null;
		this.name = null;
		this.value = 0;
		this.commands = null;
		this.params = null;
	}
	
	public Parameter(Animal turtle) {
		this.turtle = turtle;
		this.name = null;
		this.value = 0;
		this.commands = null;
		this.params = null;
	}
	
	public Parameter(String name) {
		this.turtle = null;
		this.name = name;
		this.value = 0;
		this.commands = null;
		this.params = null;
	}
	
	public Parameter(double value) {
		this.turtle = null;
		this.name = null;
		this.value = value;
		this.commands = null;
		this.params = null;
	}
	
	public Parameter(Command[] commands) {
		this.turtle = null;
		this.name = null;
		this.value = 0;
		this.commands = commands;
		this.params = null;
	}
	
	public Parameter(Parameter[][] params) {
		this.turtle = null;
		this.name = null;
		this.value = 0;
		this.commands = null;
		this.params = params;
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
	
	public Command[] getCommands() {
		return commands;
	}
	
	public Parameter[][] getParameters() {
		return params;
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
	
	public void setCommands(Command[] commands) {
		this.commands = commands;
	}
	
	public void setParameters(Parameter[][] params) {
		this.params = params;
	}
}
