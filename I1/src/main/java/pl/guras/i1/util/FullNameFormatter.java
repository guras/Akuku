package pl.guras.i1.util;

import pl.guras.i1.entity.TeamRole;

public class FullNameFormatter {

	public static String formatFullName(String firstname, String lastname, TeamRole teamRole) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(firstname);
		buffer.append(" ");
		buffer.append(lastname.toUpperCase());
		buffer.append(" (");
		buffer.append(teamRole.getValue());
		buffer.append(")");
		
		return buffer.toString();
	}
}