package model.command;

/**
 * This is the class for commands that have lists as parameters (To, Ask, Tell, and user-defined commands) in order to store lists
 * of commands, variables, or values.
 * 
 * @author Aninda Manocha
 */

public abstract class ListCommand extends Command {
	protected double numParams;
	
	public ListCommand() {
	}
}