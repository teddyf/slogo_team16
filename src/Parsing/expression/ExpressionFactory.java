package Parsing.expression;

public class ExpressionFactory {

    public <a> Expression getInfo (String name, String type, Object obj) {    
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("Command")) {
            return new MethodExpression(name, (Class)obj);

        }
        else if (type.equalsIgnoreCase("Constant")) {
            return new ConstantExpression(name, (Double)obj);

        }
        else if (type.equalsIgnoreCase("Variable")) {
            return new VariableExpression(name);
        }
        else if(type.equalsIgnoreCase("ListStart")){
            return new ListExpression(name);
        }
        return null;
    }
}
