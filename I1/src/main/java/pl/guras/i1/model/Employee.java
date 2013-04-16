package pl.guras.i1.model;

import pl.guras.i1.entity.TeamRole;
import pl.guras.i1.util.FullNameFormatter;

public class Employee {
	
	private String fullName;
	
	public Employee(String firstname, String lastname, TeamRole teamRole) {
		fullName = FullNameFormatter.formatFullName(firstname, lastname, teamRole);
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}