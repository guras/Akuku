package pl.guras.i1.entity;

public enum Color {
	RED(2), YELLOW(1), GREEN(0);
	
	private int value;
	
	private Color(int color) {
		this.value = color;
	}
	
	public int getValue() {
		return value;
	}
}
