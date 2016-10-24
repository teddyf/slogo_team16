package model.command;

import java.util.ArrayList;
import Parsing.Method;
import Parsing.Constant;
import Parsing.Expression;
import Parsing.TreeNode;
import Parsing.Variable;

public class ProcessCommand {
	public double process(TreeNode[] inputs) {
		int index = 0; 
		ArrayList<Parameter> parametersList = new ArrayList<Parameter>();
		Parameter[] parameters;
		double value = 0;
		
		while (index < inputs.length) {
			Expression nodeExpression = inputs[index].expression; 
			if (nodeExpression.getClass().equals("Method")) {
				Class method = ((Method)nodeExpression).getMethod();
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
				parameters = new Parameter[parametersList.size()];
				parameters = parametersList.toArray(parameters);
				value = command.run(parameters);
				parametersList.clear();
				parametersList.add(new Parameter(value));
			} else if (nodeExpression.getClass().equals("Constant")) {
				double constant = ((Constant)nodeExpression).getValue();
				parametersList.add(new Parameter(constant));
			} else if (nodeExpression.getClass().equals("Variable")) {
				String variable = ((Variable)nodeExpression).getName();
				parametersList.add(new Parameter(variable));
			} else {
				 
			}
			index++;
		}
		
		return value;
	}
}