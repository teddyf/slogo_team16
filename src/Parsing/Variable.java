package Parsing;

public class Variable extends Expression{
    private String name;
    
	public Variable (String name) {
        super(name);
        this.name = name;
    }
    
    public String getName() {
    	return name;
    }
}
