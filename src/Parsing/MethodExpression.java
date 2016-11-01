package Parsing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import View.helper.Coordinate;
import model.animal.Animal;
import model.command.Command;
import model.command.ListCommand;
import model.command.Parameter;
import model.command.control.variable.To;

public class MethodExpression extends Expression{

    private Class<Command> method;
    
    public MethodExpression (String name, Class<Command> method) {
        super(name);
        this.method = method;
    }
    
    @Override
    public double run(Animal turtle, TreeNode node) {
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
		System.out.println(command.getName());
		Parameter[] parameters = new Parameter[(int)command.getNumParams()];
		//int paramIndex = 0;
		int endIndex = node.getChildren().size();
		
		//if (command instanceof TurtleCommand || command instanceof ControlCommand) {
			//parameters[0] = new Parameter(turtle);
			//paramIndex++;
		//}
		//if (command instanceof SelectionCommand) {
			//command.run()
		//} else {
		parameters[0] = new Parameter(turtle);
		if (command instanceof To) {
			node = node.getChildren().get(0); //node containing command name
			parameters[1] = new Parameter(node.toString());
		}
		for (int c = 0; c < endIndex; c++) {
			if (command instanceof ListCommand) {
				TreeNode listNode = node.getChildren().get(c);
				ArrayList<TreeNode> list = createChildrenNodeList(listNode);
				parameters[c+2] = new Parameter(list);
			} else {
				//System.out.println("c " + c + " " + node.getChildren().get(c));
				parameters[c+1] = new Parameter(node.getChildren().get(c));
			}
		}
		value = command.run(parameters);
		Coordinate coordinates = new Coordinate(turtle.getX(), turtle.getY(), turtle.getHeading(), turtle.getPen(), turtle.getShowing());
		ExpressionTree.getInstance().addPoint(coordinates);
		System.out.println("DONE!!!");
		return value;
    }
    
    public ArrayList<TreeNode> createChildrenNodeList(TreeNode listNode) {
    	ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
    	for (int n = 0; n < listNode.getChildren().size(); n++) {
			nodes.add(listNode.getChildren().get(n));
		}
    	return nodes;
    }
}
