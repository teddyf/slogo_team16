package Extra;
import ErrorHandling.*;
import java.util.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Library {
    private HashSet<Class> classList;
    private HashMap<String, ArrayList<Class>> methodToClass; 
    
    public Library(){
        this.classList = new HashSet<Class>();
        this.methodToClass = new HashMap<String,ArrayList<Class>>();
    }
    
    public Library(HashSet<Class> classList){
        this.classList = classList;
        this.methodToClass = populateMethodToClass(classList); 
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
         * this will be cleaned up but it should work as is.
         */
        return null;
    }
    
    public HashMap<String,ArrayList<Class>> populateMethodToClass(HashSet<Class> classes){
        HashMap<String,ArrayList<Class>> data = new HashMap<String,ArrayList<Class>>();
        for(Class c: classes){
            for(Method method: c.getMethods()){
                String methodName = method.getName();
                if(data.containsKey(methodName)){
                    data.get(methodName).add(c);
                }
                else{
                    ArrayList<Class> temp = new ArrayList<Class>();
                    temp.add(c);
                    data.put(methodName, temp);
                }
            }
        }
        return data;
    }
    
    public boolean isMethod(String methodName){
        return methodToClass.containsKey(methodName);
    }
    
}
