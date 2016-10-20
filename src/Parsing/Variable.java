package Parsing;

public class Variable extends Expression{
    public double val;
    public Variable (String name, double val) {
        super(name);
        this.val = val;
    }
}
