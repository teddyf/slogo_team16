package View;

public enum Colors {

	BLUE("#0000FF"), 
	RED("#FF0000"), 
	GREEN("#00FF00");

	private String color;

	Colors(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return this.color;
	}

}
