package Parsing;

public class ExpressionFactory {

    public <a> Expression getInfo (String name, String type, Object obj) {    
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("Command")) {
            return new Command(name, (Class)obj);

        }
        else if (type.equalsIgnoreCase("Constant")) {
            return new Constant(name, (Double)obj);

        }
        else if (type.equalsIgnoreCase("Variable")) {
            return new Variable(name);
        }
        else if(type.equalsIgnoreCase("List")){
            return new ListBrackets(name);
        }
        return null;
    }
}
