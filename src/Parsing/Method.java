package Parsing;

import model.command.Command;
import model.command.Parameter;

public class Method extends Expression{

    private Class method;
    
    public Method (String name, Class method) {
        super(name);
        this.method = method;
    }

    public Class getMethod() {
    	return method;
    }
    
    public double run(TreeNode node) {
    	double value = 0;
    	Object obj = null;
		try {
			obj = method.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Command command = (Command)obj;
		Parameter[] parameters = new Parameter[(int)command.getNumParams()];
		
		for (int c = 0; c < node.getChildren().size(); c++) {
			parameters[c] = new Parameter(ExpressionTree.getInstance().process(node.getChildren().get(c)));
		}
		
		value = command.run(parameters);
		return value;
    }
}
