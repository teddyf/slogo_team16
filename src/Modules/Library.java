package Modules;
import ErrorHandling.*;
import java.util.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Library {
    private HashSet<Class> classList;
    
    public Library(){
        this.classList = new HashSet<Class>();
    }
    
    public void appendToClassSet(Class c){
        classList.add(c);
    }
    
    public Method getMethod(String className, String methodName) throws ClassUndefinedException{
        try{
            if(classList.contains(Class.forName(className))){
                return Class.forName(className).getMethod(methodName);
            }
        }
        catch(Exception e){
            throw new ClassUndefinedException(className + " class does not exist");
        }
        /*
         * this will be cleaned up but it should work as is.  Mr. Duval I'd prefer if you
         * don't know code we both know is not finished.  Thanks.
         */
        return null;
    }
    
}
