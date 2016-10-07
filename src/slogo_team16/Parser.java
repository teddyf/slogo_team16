package slogo_team16;

import java.util.HashMap;
import java.util.List;

public class Parser {
	
	public Parser(){
		
	}
	
	public HashMap<Integer, List<String>> parseInput(String input){
		HashMap<Integer, List<String>> parsedData = new HashMap<Integer, List<String>>();)
		String[] lines = input.split("[\\r\\n]+");
		for (int i=0; i<lines.length; i++){
			parsedData.put(i, lines[i].split("\\s"));
		}
		
		return parsedData;
	}

}
