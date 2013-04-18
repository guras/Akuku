package pl.guras.i1.model;

import java.util.List;

public class Report {
	
	private int week, year;

	private List<HighlightsLowlights> highlightsLowlights;
	
	private List<ProjectSummary> projectSummaries;
	
	private List<Employee> availableEngineers;

	public int getWeek() {
		return week;
	}

	public int getYear() {
		return year;
	}

	public List<HighlightsLowlights> getHighlightsLowlights() {
		return highlightsLowlights;
	}

	public List<ProjectSummary> getProjectSummaries() {
		return projectSummaries;
	}

	public List<Employee> getAvailableEngineers() {
		return availableEngineers;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setHighlightsLowlights(List<HighlightsLowlights> highlightsLowlights) {
		this.highlightsLowlights = highlightsLowlights;
	}

	public void setProjectSummaries(List<ProjectSummary> projectSummaries) {
		this.projectSummaries = projectSummaries;
	}

	public void setAvailableEngineers(List<Employee> availableEngineers) {
		this.availableEngineers = availableEngineers;
	}
}