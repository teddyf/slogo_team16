package Extra;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import ErrorHandling.ClassUndefinedException;
import ErrorHandling.InvalidParameterException;

public class DoTimes extends Command {
	/*
	 * runs command(s) for each value specified in the range, i.e., from (1 -
	 * limit) inclusive returns the value of the final command executed (or 0 if
	 * no commands are executed) note, variable is assigned to each succeeding
	 * value so that it can be accessed by the command(s)
	 * 
	 * DOTIMES [ variable limit ] [ command(s) ]
	 * 
	 */

	public DoTimes(String[] params) {
		super(params);
		setName("DoTimes");
	}

	@Override
	public void logic(String[] params) throws InvalidParameterException {
		String dummyClassName = "lol";
		try {
			int varLimit = Integer.parseInt(params[0]);
			for (int i = 0; i < varLimit; i++) {
				// execute the parameters that should be methods
				for (int j = 1; j < params.length; j++) {
					if (library.isMethod(params[j])) { // it's a valid method in
														// the library
						Method m = library.getMethod(params[j], dummyClassName); // TODO:
																					// where
																					// is
																					// the
																					// className
																					// coming
																					// from
						m.invoke(m);
					}
				}
			}

		} catch (NumberFormatException e) {
			System.out.println("Error in DoTimes: Variable limit is not an integer or something");
		} catch (ClassUndefinedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
