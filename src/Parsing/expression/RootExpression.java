package Parsing.expression;

import Parsing.TreeNode;
import model.animal.Animal;

/**
 * This is the RootExpression class, which extends the expression class and is used to process the root node
 * 
 * @author Teddy Franceschi
 * @author Aninda Manocha
 */

public class RootExpression extends Expression{

    public RootExpression (String name) {
        super(name);
    }
    
    /**
     * Gets the value of the last child node
     * @param turtle - the turtle to run the command on
     * @param node - the node to which the expression corresponds to
     * @return the value 
     */
    @Override
    public double run(Animal turtle, TreeNode node) {
    	double value = 0;
    	for (int c = 0; c < node.getChildren().size(); c++) {
			value = ExpressionTree.getInstance().process(turtle, node.getChildren().get(c));
		}
    	return value;
    }
}
