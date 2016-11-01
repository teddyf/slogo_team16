package View.helper;

public enum PenDash {
	
	SOLID("Solid", 1),
	DASHED("Dashed", 13),
	DOTTED("Dotted", 5);
	
	private String name;
	private int val;
	
	PenDash(String name, int val) {
		this.name= name;
		this.val = val;
	}

	public String getName() {
		return name;
	}

	public int getVal() {
		return val;
	}

}
