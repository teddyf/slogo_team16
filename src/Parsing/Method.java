package Parsing;

public class Method extends Expression{

    private Class method;
    
    public Method (String name, Class method) {
        super(name);
        this.method = method;
    }

    public Class getMethod() {
    	return method;
    }
}
