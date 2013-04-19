package pl.guras.i1.service;

import java.util.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.guras.i1.dao.ReportDao;
import pl.guras.i1.model.*;
import pl.guras.i1.util.ProjectColorGenerator;

@Service
public class ReportService {
	
	@Autowired
	private ReportDao reportDao;
	
	public Report generateReport(DateTime dateTime) {
		Report report = new Report();
		report.setWeek(dateTime.weekOfWeekyear().get());
		report.setYear(dateTime.year().get());
		report.setHighlightsLowlights(reportDao.getAllHighlightsLowlightsByWeekAndYear(dateTime));
		report.setAvailableEngineers(reportDao.getAllAvailableEngineersByWeekAndYear(dateTime));
		
		addProjectSummariesToReport(report, dateTime);
		
		return report;
	}

	private void addProjectSummariesToReport(Report report, DateTime dateTime) {
		List<ProjectSummary> projectSummaries = new ArrayList<ProjectSummary>();
		
		for (String projectName : reportDao.getAllProjectNamesByWeekAndYear(dateTime)) {
			projectSummaries.add(createProjectSummary(projectName, dateTime));
		}
		
		report.setProjectSummaries(projectSummaries);
	}

	private ProjectSummary createProjectSummary(String projectName, DateTime dateTime) {
		List<ProjectReportByEmployee> projectReports = reportDao.getAllReportsByProjectNameAndWeekAndYear(projectName, dateTime);
		
		ProjectSummary projectSummary = new ProjectSummary();
		projectSummary.setProjectName(projectName);
		projectSummary.setProjectReports(projectReports);
		projectSummary.setColor(ProjectColorGenerator.generateProjectColor(projectReports));
		
		return projectSummary;
	}
}