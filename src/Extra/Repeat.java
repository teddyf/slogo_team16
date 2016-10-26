package Extra;

import java.util.*;
import ErrorHandling.*;

public class Repeat extends Command {

    public Repeat (String[] params) {
        super(params);
        setName("Repeat");
    }

    @Override
    public void logic (String[] params) throws InvalidParameterException {
        int indexTo = toInt(params[0]);
        ArrayList<String> futureParams = new ArrayList<String>();
        for (int i = 0; i < indexTo; i++) {
            for (int j = 1; j < params.length; j++) {
                /*
                 * TODO
                 * Will need to check if character parameter is a special character, variable or
                 * number in order to parse approrpiately and run properly
                 */
                if (isNumber(params[j])) {
                    futureParams.add(params[j]);
                }
                else if (library.isMethod(params[j])) {
                    // String[] paramsAsArray = futureParams.toArray(new
                    // String[futureParams.size()]);
                    
                }
            }
        }

    }
}
