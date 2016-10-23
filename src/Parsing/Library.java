package Parsing;
import java.util.*;
public class Library {
    
    public HashMap<String ,Class> data;
    
    public Library(){
        this.data = new HashMap<String, Class>();
    }
    
    public Class getCommand(String input){
        if(data.containsKey(input)){
            return data.get(input);
        }
        else return this.getClass();
    }
}
