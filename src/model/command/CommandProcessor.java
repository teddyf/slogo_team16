package model.command;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import Controller.AnimalController;
import ErrorHandling.InvalidLabelException;
import Parsing.Method;
import Parsing.ParserRunner;
import Parsing.ProgramParser;
import Parsing.Constant;
import Parsing.Expression;
import Parsing.ExpressionTree;
import Parsing.TreeNode;
import Parsing.Variable;
import model.animal.Animal;
import model.command.turtle.TurtleCommand;

public class CommandProcessor {
	private ArrayList<Command> commands;
	private ArrayList<Parameter[]> parameters;
	
	public CommandProcessor() {
		commands = new ArrayList<Command>();
		parameters = new ArrayList<Parameter[]>();
	}
	
	private ArrayList<TreeNode> getNodes() throws FileNotFoundException, NoSuchMethodException, SecurityException, 
	ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, 
	InvocationTargetException, NoSuchFieldException, InvalidLabelException {
		ProgramParser myProgramParser = new ProgramParser();
		ParserRunner myParserRunner = new ParserRunner("English", myProgramParser);
		
		String[][] line = myParserRunner.combineAllLines();
		String[][] markedLine = myParserRunner.markDepth(line);
		ExpressionTree tree = new ExpressionTree();
		
		tree.buildTree(markedLine);
		ArrayList<TreeNode> nodes = tree.dfs();
		
		return nodes;
	}
	
	public double processCommands(Animal turtle, ArrayList<TreeNode> inputs) {
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
	
	private boolean isCommand()
	public void run(Animal turtle) throws FileNotFoundException, NoSuchMethodException, SecurityException, ClassNotFoundException, 
	InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, 
	InvalidLabelException {
		ArrayList<TreeNode> nodes = getNodes();
		processCommands(turtle, nodes);
	}
}