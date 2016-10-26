package View.helper;

/**
 * 
 * @author Jordan Frazier
 *
 */
public enum Colors {
	BLACK("#000000"),
	WHITE("#FFFFFF"),
	BLUE("#0000FF"), 
	RED("#FF0000"), 
	GREEN("#00FF00");

	private String color;

	Colors() {
		
	}
	Colors(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return this.color;
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

}
