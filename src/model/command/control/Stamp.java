package model.command.control;

import Parsing.expression.ConstantExpression;
import Parsing.expression.ExpressionTree;
import Parsing.expression.VariableExpression;
import model.animal.Animal;
import model.command.Parameter;
import model.command.turtle.movement.TurtleMovement;


public class Stamp extends TurtleMovement {
    private final double paramCount;

    public Stamp () {
        super();
        numParams = 1;
        paramCount = 0;
    }

    /**
     * Draws the image of the turtle in its current settings on the workspace display
     * returns the index of the turtle's image used for the stamp
     * 
     * @param params - array of parameters
     * @return the number of pixels
     */
    @Override
    public double run (Parameter[] params) {
        //Insert front end method that handles adding stamp
        Animal turtle = params[0].getAnimal();
        turtle.setShowing(1);
        return turtle.getShowing();
    }
}
