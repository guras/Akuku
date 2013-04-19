package pl.guras.i1.model;

import pl.guras.i1.entity.TeamRole;

public class ReportStatusByEmployee {

	private Employee employee;
	
	private boolean reportDone;

	public ReportStatusByEmployee(long employeeId, String firstname, String lastname, TeamRole teamRole, boolean reportDone) {
		employee = new Employee(employeeId, firstname, lastname, teamRole);
		this.reportDone = reportDone;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public boolean isReportDone() {
		return reportDone;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setReportDone(boolean reportDone) {
		this.reportDone = reportDone;
	}
}