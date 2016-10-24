package model.command;

import java.util.ArrayList;

import Controller.AnimalController;
import Parsing.Method;
import Parsing.Constant;
import Parsing.Expression;
import Parsing.TreeNode;
import Parsing.Variable;
import model.animal.Animal;
import model.animal.Turtle;
import model.command.turtle.TurtleCommand;

public class ProcessCommand {
	public double process(AnimalController ac, Animal turtle, ArrayList<TreeNode> inputs) {
		int index = 0; 
		ArrayList<Parameter> parametersList = new ArrayList<Parameter>();
		Parameter[] parameters;
		double value = 1;
		
		for(int i = 0; i < inputs.size(); i++) {
			System.out.println(inputs.get(i).expression.getClass());
		}
		while (index < inputs.size()) {
			Expression nodeExpression = inputs.get(index).expression; 
			if (nodeExpression.getClass().getSimpleName().equals("Method")) {
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
				parameters = new Parameter[(int)command.getNumParams()];
				int startIndex = parametersList.size()-(int)command.getNumParams();
				System.out.print(parametersList.size());
				System.out.println((int)command.getNumParams());
				if (command instanceof TurtleCommand) {
					//Animal turtle = ac.getActiveAnimalPaneGUI().getAnimalPane().getMyAnimalList().get(0);
					//Animal turtle = new Turtle(15, 15, 3, 3);
					parameters[0] = new Parameter(turtle);
				} else {
					parameters[0] = parametersList.get(startIndex);
				}
				for(int i = 1; i < command.getNumParams(); i++) {
					parameters[i] = parametersList.get(startIndex+i);
				}
				value = command.run(parameters);
				System.out.println("VALUE " + value);
				parametersList.clear();
				parametersList.add(new Parameter(value));
			} else if (nodeExpression.getClass().getSimpleName().equals("Constant")) {
				double constant = ((Constant)nodeExpression).getValue();
				parametersList.add(new Parameter(constant));
			} else if (nodeExpression.getClass().getSimpleName().equals("Variable")) {
				String variable = ((Variable)nodeExpression).getName();
				parametersList.add(new Parameter(variable));
			} else {
				 
			}
			index++;
		}
		
		return value;
	}
}