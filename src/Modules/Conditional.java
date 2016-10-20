package Modules;

import ErrorHandling.InvalidParameterException;

public class Conditional extends Command {
	public Conditional(String[] params) {
		super(params);
		setName("Conditional");
	}
	
	@Override
    public void logic (String[] params) throws InvalidParameterException {
		
	}
}