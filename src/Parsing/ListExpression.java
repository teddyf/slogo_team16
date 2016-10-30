package Parsing;

import java.util.List;
import java.util.Map;

import View.helper.Coordinate;
import model.animal.Animal;

public class ListExpression extends Expression{

    public ListExpression (String name) {
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
