package pl.guras.i1.model;

import java.util.List;

public class ProjectSummary {
	
	private String projectName, color;
	
	private List<ProjectReportByEmployee> projectReports;

	public String getProjectName() {
		return projectName;
	}

	public String getColor() {
		return color;
	}

	public List<ProjectReportByEmployee> getProjectReports() {
		return projectReports;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setProjectReports(List<ProjectReportByEmployee> projectReports) {
		this.projectReports = projectReports;
	}
}