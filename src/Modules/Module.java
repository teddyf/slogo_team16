package Modules;
import java.util.*;
import ErrorHandling.InvalidParameterException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class Module {
    String[] params;
    private Library library;
    String name;
    public Module(String[] params){
       this.params = params;
       Library library = new Library();
    }
    
    public abstract void logic(String[] params) throws InvalidParameterException;
    
    protected int toInt(int index) throws InvalidParameterException{
        int val;
        try{
            val = Integer.parseInt(params[index]);
            return val;
        }
        catch(Exception e){
            throw new InvalidParameterException("Not a valid number");
        }
    }
    
    protected double toDouble(int index) throws InvalidParameterException{
        double val;
        try{
            val = Double.parseDouble(params[index]);
            return val;
        }
        catch(Exception e){
            throw new InvalidParameterException("Not a valid number");
        }
    }
    
    public void setName(String name){
        this.name = name;
    }
    

    
}
