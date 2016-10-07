package Translator;
import java.lang.reflect.*;

/**
 * Responsible for Slogo commands that have iteration functionality
 * @author Lucy Zhang
 *
 */
public class Iterator {

	/**
	 * Responsible for "repeat" command
	 * @param numTimes Number of times to iterate
	 * @param methodName The method name as a string
	 * @param className The class that the method belongs to as a string
	 * @throws NoSuchMethodException 
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public void repeat(int numTimes, String methodName, String className) throws NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		for (int i=0; i<numTimes; i++){
			//does not currently accept arguments!!!
			Method m = Class.forName(className).getMethod(methodName);
			m.invoke(Class.forName(className).newInstance());
		}
	}
}
