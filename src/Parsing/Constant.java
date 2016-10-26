package Parsing;

public class Constant extends Expression{

    private double val;
    
    public Constant (String name, double val) {
        super(name);
        this.val = val;
    }
    
    public double getValue() {
    	return val;
    }
    
}
