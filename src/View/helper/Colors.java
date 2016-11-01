package View.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Jordan Frazier
 *
 */
public enum Colors {
	BLACK("Black", "#000000", 0),
	WHITE("White", "#FFFFFF", 1),
	BLUE("Blue", "#0000FF", 2), 
	RED("Red", "#FF0000", 3), 
	GREEN("Green", "#00FF00", 4);

	private String color;
	private String hexColor;
	private int ID;

	Colors(String color, String hexColor, int id ) {
		this.color = color;
		this.hexColor = hexColor;
		this.ID = id;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public String getHexColor() {
		return this.hexColor;
	}
	
	public int getId() {
		return this.ID;
	}
	
	public void setId(int id) {
			for(Colors c : Colors.values()) {
				if(c.getId() == id) {
					System.out.println("Can't have two Color IDs the same");
					// throw exception error
					break;
				}
			}	
			this.setId(id);
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
	
	public Map<String, Integer> getColorIdMap() {
		Map<String, Integer> map = new HashMap<>();
		for(Colors c : Colors.values()) {
			map.put(c.toString(), c.getId());
		}
		return map;
	}
	
	
	

}
