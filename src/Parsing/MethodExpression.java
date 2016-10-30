package Parsing;

import model.animal.Animal;
import model.command.Command;
import model.command.Parameter;

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
		for (int c = 0; c < endIndex; c++) {
			/*if (command instanceof SelectionCommand && c != 0) {
				parameters[paramIndex] = new Parameter(node.getChildren().get(c));
			} else {
				System.out.println(c + " " + node.getChildren().get(c));
				parameters[paramIndex] = new Parameter(ExpressionTree.getInstance().process(turtle, node.getChildren().get(c)));
			}*/
			System.out.println("c " + c + " " + node.getChildren().get(c));
			parameters[c+1] = new Parameter(node.getChildren().get(c));
			//paramIndex++;
		}
		value = command.run(parameters);
		System.out.println("DONE!!!");
		return value;
    }
}
