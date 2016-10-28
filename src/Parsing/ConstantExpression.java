package Parsing;

import model.animal.Animal;

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
