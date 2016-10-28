package Parsing;

import model.animal.Animal;

public class RootExpression extends Expression{

    public RootExpression (String name) {
        super(name);
    }
    
    @Override
    public double run(Animal turtle, TreeNode node) {
    	double value = 0;
    	for (int c = 0; c < node.getChildren().size(); c++) {
			value = ExpressionTree.getInstance().process(turtle, node.getChildren().get(c));
		}
    	return value;
    }
}
