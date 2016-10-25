package Extra;

import java.util.HashMap;

import ErrorHandling.InvalidParameterException;

public class Variable extends Command{
	
	private HashMap<String, String> variables = new HashMap<String, String>();
	
	public Variable(String[] params) {
		super(params);
		setName("VariableCreator");
	}

	public HashMap<String, String> getVariables() {
		return variables;
	}

	private void makeOrSetVariable(String nameOfVariable, String value){
		variables.put(nameOfVariable,value);
	}
	
	private boolean variableExists(String variableName){
		return (variables.get(variableName)!=null);
	}

	@Override
	public void logic(String[] params) throws InvalidParameterException {
		// TODO Auto-generated method stub
		if (library.isMethod(params[0])){
			String variableName = params[1];
			String value = params[2];
			makeOrSetVariable(variableName, value);
		}
		
	}

}
