package Parsing;

public class Constant extends Expression{

    public double val;
    public Constant (String name, double val) {
        super(name);
        this.val = val;
    }
    
}
