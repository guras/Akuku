package pl.guras.i1.model;

import pl.guras.i1.entity.TeamRole;
import pl.guras.i1.util.FullNameFormatter;

public class Employee {
	
	private long id;
	
	private String fullName;
	
	public Employee(long id, String firstname, String lastname, TeamRole teamRole) {
		this(firstname, lastname, teamRole);
		this.id = id;
	}
	
	public Employee(String firstname, String lastname, TeamRole teamRole) {
		fullName = FullNameFormatter.formatFullName(firstname, lastname, teamRole);
	}

	public long getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}