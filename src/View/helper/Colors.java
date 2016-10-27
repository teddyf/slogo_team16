package View.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Jordan Frazier
 *
 */
public enum Colors {
	BLACK("Black", "#000000"),
	WHITE("White", "#FFFFFF"),
	BLUE("Blue", "#0000FF"), 
	RED("Red", "#FF0000"), 
	GREEN("Green", "#00FF00");

	private String color;
	private String hexColor;

	Colors(String color, String hexColor ) {
		this.color = color;
		this.hexColor = hexColor;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public String getHexColor() {
		return this.hexColor;
	}
	
	public String[] getAllColors() {
		String[] allColors = new String[Colors.values().length];
		int i = 0;
		for(Colors c : Colors.values()) {
			allColors[i] = c.toString();
			i++;
		}
		return allColors;
	}
	
	public Map<String, String> getColorMap() {
		Map<String, String> map = new HashMap<>();
		for(Colors c : Colors.values()) {
			map.put(c.toString(), c.getHexColor());
		}
		return map;
	}

}
