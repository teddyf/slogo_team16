/*
 * Aninda Manocha
 * This entire file is part of my masterpiece.
 */

package Parsing.expression;

import Controller.Data;
import Parsing.TreeNode;
import model.animal.Animal;
import model.variable.Variable;

/**
 * This is the VariableExpression class, which extends the expression class and is used to process variables that are entered as
 * parameters
 * 
 * @author Teddy Franceschi
 * @author Aninda Manocha
 */

public class VariableExpression extends Expression{
    private String name;
    private boolean local;
    
	public VariableExpression (String name) {
        super(name);
        this.name = name;
    }
    
    public String getName() {
    	return name;
    }
    
    /**
     * Gets the value of the variable
     * @param turtle - the turtle to run the command on
     * @param node - the node to which the expression corresponds to
     * @return the value 
     */
    @Override
    public double run(Animal turtle, TreeNode node) {
    	String commandName = ExpressionTree.getInstance().getCurrentCommand();
    	Variable variable;
    	if (Data.getInstance().containsCommand(commandName) && Data.getInstance().containsLocalVariable(commandName, name)) { 
    		//running user-defined command
    		variable = Data.getInstance().getLocalVariable(commandName, name);
    		return variable.getValue();
    	} else {
    		variable = Data.getInstance().getVariable(name);
    		return variable.getValue();
    	}
    }
}
