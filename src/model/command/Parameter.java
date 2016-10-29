package model.command;

import Parsing.TreeNode;
import model.animal.Animal;

public class Parameter {
	private Animal turtle;
	private String name;
	private double value;
	private TreeNode node;
	private String[] variables;
	
	public Parameter() {
		this.turtle = null;
		this.name = null;
		this.value = 0;
		this.node = null;
		this.variables = null;
	}
	
	public Parameter(Animal turtle) {
		this.turtle = turtle;
	}
	
	public Parameter(String name) {
		this.name = name;
	}
	
	public Parameter(double value) {
		this.value = value;
	}
	
	public Parameter(TreeNode node) {
		this.node = node;
	}
	
	public Parameter(String[] variables) {
		this.variables = variables;
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
	
	public TreeNode getNode() {
		return node;
	}
	
	public String[] getVariables() {
		return variables;
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
	
	public void setList(TreeNode node) {
		this.node = node;
	}
	
	public void setVariables(String[] variables) {
		this.variables = variables;
	}
}
