package Translator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import slogo_team16.Console;

public class BasicCommands {

	public BasicCommands() {

	}

	/**
	 * Responsible for "repeat" command
	 * 
	 * @param numTimes
	 *            Number of times to iterate
	 * @param methodName
	 *            The method name as a string
	 * @param className
	 *            The class that the method belongs to as a string
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public void repeat(int numTimes, String methodName, String className)
			throws NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException {
		for (int i = 0; i < numTimes; i++) {
			// does not currently accept arguments!!!
			Method m = Class.forName(className).getMethod(methodName);
			m.invoke(Class.forName(className).newInstance());
		}
	}

	public void print(String text, Console console) {
		console.clearConsole();
		console.writeToConsole(text);
	}


}
