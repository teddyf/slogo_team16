package model.command;

import ErrorHandling.Error;

/**
 * This is the class for a general command. Each individual command has a separate class and all of these subclasses extend this
 * superclass as all commands have a run() method in order for the commands to run.
 * 
 * @author Aninda Manocha
 */

public abstract class Command {
	protected double numParams;
	
	public Command() {
	}

	/**
	 * Runs the command and produces a value of type double. It is assumed that the correct data types are entered into this
	 * method as parameters, but if they are not, then an error message appears.
	 * @param params - array of parameters
	 * @return - the value from the command
	 */
	public abstract double run(Parameter[] params);
	
	/**
	 * Gets the name of the command
	 * @return command name
	 */
	public String getName() { 
		return this.getClass().getSimpleName();
	}
	
	/**
	 * Gets the number of parameters for the command
	 * @return number of parameters
	 */
	public double getNumParams() {
		return numParams;
	}
	
	/**
	 * Displays an error message indicating that the user entered an incorrect data type as a parameter
	 * @param command - the command for which the user entered an invalid parameter
	 */
	public void commandInputError(String command) {
		Error.getInstance().displayError("Data Type Error!", "Invalid Data Entered", 
				"The wrong type of input has been entered into the " + command + " command.");
	}
}