package Modules;
import java.util.*;
import ErrorHandling.InvalidParameterException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class Module {
    String[] params;
    protected Library library;
    String name;
    public Module(String[] params){
       this.params = params;
       library = new Library();
    }
    
    public abstract void logic(String[] params) throws InvalidParameterException;
    
    protected int toInt(String a) throws InvalidParameterException{
        int val;
        try{
            val = Integer.parseInt(a);
            return val;
        }
        catch(Exception e){
            throw new InvalidParameterException("Not a valid number");
        }
    }
    
    protected double toDouble(String a) throws InvalidParameterException{
        double val;
        try{
            val = Double.parseDouble(a);
            return val;
        }
        catch(Exception e){
            throw new InvalidParameterException("Not a valid number");
        }
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public boolean isNumber(String a){
        try{
            double val = Double.parseDouble(a);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
}
