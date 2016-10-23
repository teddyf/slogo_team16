package Parsing;

public class Command extends Expression{

    public Class method;
    public Command (String name, Class method) {
        super(name);
        this.method = method;
    }

}
