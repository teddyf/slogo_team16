package model.command;

import java.util.ArrayList;

import Parsing.TreeNode;
import model.animal.Animal;

/**
 * This is the Parameter class, which is a data structure that holds data and attributes pertaining to a parameter for a command.
 * A parameter can be a turtle (the turtle to run a command on), a string (the name of a variable), a node (a command or value), 
 * or a list of nodes (list of commands, variables, or values). A parameter can be created with only one input and serves to wrap
 * different types of parameters as Parameter objects in order to create arrays of Parameter objects (for the commands).
 * 
 * @author Aninda Manocha
 */

public class Parameter {
	private Animal turtle;
	private String name;
	private double value;
	private TreeNode node;
	private ArrayList<TreeNode> nodes;
	
	//Default constructor
	public Parameter() {
		this.turtle = null;
		this.name = null;
		this.value = 0;
		this.node = null;
		this.nodes = null;
	}
	
	/*****CONSTRUCTORS*****/
	
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
	
	public Parameter(ArrayList<TreeNode> nodes) {
		this.nodes = nodes;
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
	
	public ArrayList<TreeNode> getNodes() {
		return nodes;
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
	
	public void setNodes(ArrayList<TreeNode> nodes) {
		this.nodes = nodes;
	}
}
