package Parsing.expression;

import Parsing.TreeNode;
import model.animal.Animal;

/**
 * This is the Expression class, which is a property of a tree node and determines what type the node is (command, bracket, 
 * variable, root, or constant)
 * 
 * @author Teddy Franceschi
 * @author Aninda Manocha
 */

public abstract class Expression {
    private String name;
    public Expression(String name){
        this.name = name;
    }
    
    public String toString(){
        return this.name;
    }
    
    /**
     * Processes the expression based on what type of expression it is (method, variable constant, list bracket) in order to 
     * obtain a double value that will be passed to the command processor.
     * @param turtle - the turtle to run the command on
     * @param node - the node to which the expression corresponds to
     * @return the value of the expression
     */
    public abstract double run(Animal turtle, TreeNode node);
}
