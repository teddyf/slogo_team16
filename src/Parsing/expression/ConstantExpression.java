package Parsing.expression;

import Parsing.TreeNode;
import model.animal.Animal;

/**
 * This is the ConstantExpression class, which extends the expression class and is used to process constants that are entered as
 * parameters
 * 
 * @author Teddy Franceschi
 * @author Aninda Manocha
 */

public class ConstantExpression extends Expression{

    private double value;
    
    public ConstantExpression (String name, double value) {
        super(name);
        this.value = value;
    }
    
    @Override
    public double run(Animal turtle, TreeNode node) {
    	return value;
    }
}
