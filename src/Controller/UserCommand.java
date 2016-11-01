package Controller;

import java.util.HashMap;
import model.command.Command;
import model.variable.Variable;

public class UserCommand {
	private Command command;
	private HashMap<String,Variable> localVariables;
	
	public UserCommand(Command command) {
		this.command = command;
		this.localVariables = new HashMap<String,Variable>();
	}
	
	public UserCommand(Command command, HashMap<String,Variable> localVariables) {
		this.command = command;
		this.localVariables = localVariables;
	}
	
	public Command getCommand() {
		return command;
	}
	
	public HashMap<String,Variable> getLocalVariables() {
		return localVariables;
	}

	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void setLocalVariables(HashMap<String,Variable> localVariables) {
		this.localVariables = localVariables;
	}
}