package Modules;
import ErrorHandling.*;
public class Repeat extends Module{
    
    Library library = new Library();
    public Repeat (String[] params) {
        super(params);
        setName("Repeat");
    }

    @Override
    public void logic (String[] params) throws InvalidParameterException {
        int indexTo = toInt(0);
        for(int i = 0; i < indexTo; i++){
            
        }
        
    }
}
