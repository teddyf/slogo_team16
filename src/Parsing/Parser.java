package Parsing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import Translator.BasicCommands;
import View.helper.Console;

/**
 * Handles parsing input
 */
/**
 * @author Lucy Zhang
 *
 */
public class Parser {
	private Map<Integer, String[]> parsedData;
	private BasicCommands commands = new BasicCommands();

	public Parser() {

	}

	public Map<Integer, String[]> parseInput(String input) {
		parsedData = new HashMap<Integer, String[]>();
		String[] lines = (String[]) input.split("[\\r\\n]+");
		System.out.print(lines);
		System.out.println("Split lines: ");
		for (int i = 0; i < lines.length; i++) {
			String[] splitLine = lines[i].split(" ?(?<!\\G)((?<=[^\\p{Punct}])(?=\\p{Punct})|\\b) ?");
			System.out.println(Arrays.toString(splitLine));
			parsedData.put(i, splitLine);
		}

		return parsedData;
	}
	

	// for testing
	public void checkForPrintCommand(String command, Console console) {
		for (Map.Entry<Integer, String[]> entry : parsedData.entrySet()) {
			Integer key = entry.getKey();
			String[] value = entry.getValue();
			for (int i = 0; i < value.length; i++) {
				if (value[i].equalsIgnoreCase(command)){ //need to make a properties file or something with all the commands
					System.out.println("Found command!"); 
					commands.print(value[i+1], console);
				}
			}
		}

	}

}
