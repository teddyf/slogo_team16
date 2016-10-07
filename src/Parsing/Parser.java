package Parsing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Handles parsing input
 */
/**
 * @author Lucy Zhang
 *
 */
public class Parser {
	
	public Parser(){
		
	
	}
	
	public HashMap<Integer, String[]> parseInput(String input){
		HashMap<Integer, String[]> parsedData = new HashMap<Integer, String[]>();
		String[] lines = (String[]) input.split("[\\r\\n]+");
		System.out.print(lines);
		System.out.println("Split lines: ");
		for (int i=0; i<lines.length; i++){
			String[] splitLine =  lines[i].split(" ?(?<!\\G)((?<=[^\\p{Punct}])(?=\\p{Punct})|\\b) ?");
			
			System.out.println(Arrays.toString(splitLine));
			parsedData.put(i, splitLine);
		}
		
		return parsedData;
	}

}
