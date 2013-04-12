package pl.guras.i1.entity;

/**
 * @author mgorecki
 */
public enum Project {
	CHOCKAPIC("C1"), CHEERIOS("C2")	, NESQUICK("N1");

	private String code;

	private Project(String code) {
		this.code = code;
	}
	
	public String code() {
		return this.code;
	}
	
}
