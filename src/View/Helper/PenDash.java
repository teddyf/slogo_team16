package View.helper;

import java.util.HashMap;
import java.util.Map;
/**
 * An enum housing the options of the dash values for the pen
 * @author Jordan Frazier
 *
 */
public enum PenDash {
	
	SOLID("Solid", 1),
	DASHED("Dashed", 13),
	DOTTED("Dotted", 5);
	
	private String name;
	private double val;
//	private Map<Double, String> idMap;
	
//	PenDash() {
//		setIdMap();
//	}
	
	PenDash(String name, double val) {
		this.name= name;
		this.val = val;
	}

	public String getName() {
		return name;
	}

	public double getVal() {
		return val;
	}
	
	public Map<Double, String> getIdMap() {
		Map<Double, String> idMap = new HashMap<>();
		for(PenDash p : PenDash.values()) {
			idMap.put(p.getVal(), p.getName());
		}
		return idMap;
	}
	
//	public Map<Double, String> getIdMap() {
//		return idMap;
//	}

}
