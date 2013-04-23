package pl.guras.i1.model;

import pl.guras.i1.entity.*;

public class ProjectReportByEmployee {
	
	private String mainAchievements, doneLastWeek, nextSteps, edc, etc;
	
	private Employee employee;
	
	private Color color;
	
	public ProjectReportByEmployee(String firstname, String lastname, TeamRole teamRole, Color color, String mainAchievements, String doneLastWeek, String nextSteps, String edc, String etc) {
		employee = new Employee(firstname, lastname, teamRole);
		
		this.color = color;
		this.mainAchievements = mainAchievements;
		this.doneLastWeek = doneLastWeek;
		this.nextSteps = nextSteps;
		this.edc = edc;
		this.etc = etc;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public String getMainAchievements() {
		return mainAchievements;
	}

	public String getDoneLastWeek() {
		return doneLastWeek;
	}

	public String getNextSteps() {
		return nextSteps;
	}

	public String getEdc() {
		return edc;
	}

	public String getEtc() {
		return etc;
	}
	
	public Color getColor() {
		return color;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setMainAchievements(String mainAchievements) {
		this.mainAchievements = mainAchievements;
	}

	public void setDoneLastWeek(String doneLastWeek) {
		this.doneLastWeek = doneLastWeek;
	}

	public void setNextSteps(String nextSteps) {
		this.nextSteps = nextSteps;
	}

	public void setEdc(String edc) {
		this.edc = edc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}