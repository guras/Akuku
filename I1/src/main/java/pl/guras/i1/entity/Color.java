<<<<<<< HEAD
package pl.guras.i1.entity;

public enum Color {
	RED("#FF0000", 1), YELLOW("#FFFF00", 2), GREEN("#00FF00", 3);
	
	private String value;
	
	private int priority;

	private Color(String value, int priority) {
		this.value = value;
		this.priority = priority;
	}

	public String getValue() {
		return value;
	}

	public int getPriority() {
		return priority;
	}
}
=======
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
>>>>>>> branch 'master' of https://github.com/guras/Akuku.git
