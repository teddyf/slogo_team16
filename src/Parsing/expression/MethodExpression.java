package Parsing.expression;

import java.util.ArrayList;
import Controller.Data;
import ErrorHandling.Error;
import Parsing.TreeNode;
import View.helper.Coordinate;
import model.animal.Animal;
import model.command.Command;
import model.command.ListCommand;
import model.command.NewCommand;
import model.command.Parameter;
import model.command.control.variable.To;

/**
 * This is the MethodExpression class, which extends the expression class and is used to process commands that are entered so that 
 * their parameters are entered appropriately
 * 
 * @author Teddy Franceschi
 * @author Aninda Manocha
 */

public class MethodExpression extends Expression{

    private Class<Command> method;
    private Command command;
    private String prevCurrentCommand;
    private Animal turtle;
    private TreeNode node;
    
    public MethodExpression (String name, Class<Command> method) {
        super(name);
        this.method = method;
    }
    
    @Override
    public double run(Animal turtle, TreeNode node) {
    	double value = 0;
    	this.turtle = turtle;
    	this.node = node;
    	Object obj = null;
		try {
			obj = method.newInstance();
		} catch (InstantiationException e) {
			Error.getInstance().displayError("Invalid Input Error!", "Invalid Command Name", 
					"You have entered a command name that does not exist.");
			return -1;
		} catch (IllegalAccessException e) {
			Error.getInstance().displayError("Invalid Input Error!", "Invalid Command Name", 
					"You have entered a command name that does not exist.");
			return -1;
		}
		command = getCommand(obj);
		if (command == null) {
			return -1;
		}
		Parameter[] parameters = createParameters(command);
		value = command.run(parameters);
		if (ExpressionTree.getInstance().getCurrentCommand() != null && !ExpressionTree.getInstance().getCurrentCommand().equals(prevCurrentCommand) 
				&& command instanceof NewCommand) {
			ExpressionTree.getInstance().setCurrentCommand(prevCurrentCommand); //reset so that a local variable isn't always returned
		}
		Coordinate coordinates = new Coordinate(turtle.getX(), turtle.getY(), turtle.getHeading(), turtle.getPen(), turtle.getShowing());
		ExpressionTree.getInstance().addPoint(coordinates);
		return value;
    }
    
    /**
     * Gets the instance of the command that corresponds to the method that the tree node was created for. If the command is not 
     * a defined command, it is processed as a user-defined command.
     * @param obj - the object
     * @return the command
     */
    public Command getCommand(Object obj) {
    	Command command = (Command)obj;
		if (command instanceof NewCommand) {
			if (Data.getInstance().containsCommand(node.toString())) { //check if command exists
				command = Data.getInstance().getCommand(node.toString());
				prevCurrentCommand = ExpressionTree.getInstance().getCurrentCommand();
				ExpressionTree.getInstance().setCurrentCommand(command.getName());
			} else {
				Error.getInstance().displayError("Invalid Input Error!", "Invalid Command Name", 
						"You have entered a command name that does not exist.");
				return null;
			}
		}
		return command;
    }
    
    /**
     * Gets the parameters for the command based on the number of parameters necessary and the command type
     * @param command - the command whose parameters are created
     * @return array of parameters
     */
    public Parameter[] createParameters(Command command) {
    	Parameter[] parameters = new Parameter[(int)command.getNumParams()];
		int paramIndex = 1;
		int endIndex = node.getChildren().size();
		parameters[0] = new Parameter(turtle);
		if (command instanceof To) {
			node = node.getChildren().get(0); //node containing command name
			parameters[1] = new Parameter(node.toString());
			paramIndex++;
			endIndex = node.getChildren().size();
		}
		for (int c = 0; c < endIndex; c++) {
			if (command instanceof ListCommand) {
				TreeNode listNode = node.getChildren().get(c);
				ArrayList<TreeNode> list = createChildrenNodeList(listNode);
				parameters[paramIndex] = new Parameter(list);
				paramIndex++;
			} else {
				parameters[c+1] = new Parameter(node.getChildren().get(c));
			}
		}
		return parameters;
    }
    
    /**
     * Creates a list of tree nodes that are the children of a tree node that holds a list bracket. A list bracket serves as the
     * parent of several nodes, each of which is in the list that was entered as input. The list bracket indicates to the tree 
     * builder that there is a list, so the items in the list are processed as children nodes. This method therefore gets these
     * children nodes so that they can be processed.
     * @param listNode - the tree node that holds a list bracket
     * @return list of tree nodes
     */
    public ArrayList<TreeNode> createChildrenNodeList(TreeNode listNode) {
    	ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
    	for (int n = 0; n < listNode.getChildren().size(); n++) {
			nodes.add(listNode.getChildren().get(n));
		}
    	return nodes;
    }
    
    /**
     * Gets the name of the command corresponding to this node
     * @return command name
     */
    public String getMethodType() {
    	return method.getSimpleName();
    }
}
