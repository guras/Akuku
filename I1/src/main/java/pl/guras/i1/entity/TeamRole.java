package pl.guras.i1.entity;

public enum TeamRole {
	
	DEVELOPER("dev"), INTEGRATOR("int"), VALIDATOR("val"), TEAM_LEADER("tm");
	
	private String value;
	
	private TeamRole(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}