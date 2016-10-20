package Parsing;

import java.util.*;

import model.animal.*;

import java.lang.reflect.*;

/**
 * 
 * @author theodorefranceschi
 *
 */
public class Dictionary {
    private Turtle turtle;
    private HashMap<String,Method> methods;
    
    public Dictionary(){
        this.turtle = new Turtle(0, 0);
        populateMethods(turtle);
    }
    
    private void populateMethods(Object a){
        Method[] methods = a.getClass().getMethods();
        for(int i = 0; i < methods.length; i++){
            this.methods.put("temporary",methods[i] );
        }
    }
}
