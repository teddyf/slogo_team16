package Parsing;

import model.DataSingleton;
import model.animal.Animal;
import model.variable.Variable;

public class VariableExpression extends Expression{
    private String name;
    
	public VariableExpression (String name) {
        super(name);
        this.name = name;
    }
    
    public String getName() {
    	return name;
    }
    
    @Override
    public double run(Animal turtle, TreeNode node) {
    	Variable variable = DataSingleton.getInstance().getVariable(name);
    	return variable.getValue();
    }
}
