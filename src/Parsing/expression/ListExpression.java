package Parsing.expression;

import Parsing.TreeNode;
import model.animal.Animal;

/**
 * This is the ListExpression class, which extends the expression class and is used to process brackets that appear before lists
 * so that commands with parameter lists can be processed
 * 
 * @author Teddy Franceschi
 * @author Aninda Manocha
 */

public class ListExpression extends Expression{

    public ListExpression (String name) {
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
