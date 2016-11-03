/**
 * This is the class for a general command, which all command classes extend
 * 
 * @author Aninda Manocha
 */

package model.command;

import ErrorHandling.Errors;

public abstract class Command {
	protected double numParams;
	
	public Command() {
	}

	public abstract double run(Parameter[] params);
	
	public String getName() { 
		return this.getClass().getSimpleName();
	}
	
	public double getNumParams() {
		return numParams;
	}
	
	/**
	 * Displays an error message indicating that the user entered an incorrect data type as a parameter. 
	 * @param command - the command for which the user entered an invalid parameter
	 */
	public void commandInputError(String command) {
		Errors.getInstance().displayError("Data Type Error!", "Invalid Data Entered", 
				"The wrong type of input has been entered into the " + command + " command.");
	}
}