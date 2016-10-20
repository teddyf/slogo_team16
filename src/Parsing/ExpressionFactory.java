package Parsing;

public class ExpressionFactory {

    public <a> Expression getInfo (a[] expressionType) {
        
        String type = (String) expressionType[0];
        String name = (String) expressionType[1];
        
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("Command")) {
            return new Command(name, (Class)expressionType[2]);

        }
        else if (type.equalsIgnoreCase("Constant")) {
            return new Constant(name, (Double)expressionType[2]);

        }
        else if (type.equalsIgnoreCase("Variable")) {
            return new Variable(name, (Double)expressionType[2]);
        }

        return null;
    }
}
