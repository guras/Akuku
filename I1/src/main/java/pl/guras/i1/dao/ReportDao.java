package pl.guras.i1.dao;

import static pl.guras.i1.entity.WeeklyReport.*;
import static pl.guras.i1.entity.ProjectReport.*;
import java.util.*;
import javax.persistence.*;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.guras.i1.entity.*;
import pl.guras.i1.model.*;

@Repository
public class ReportDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public List<HighlightsLowlights> getAllHighlightsLowlightsByWeekAndYear(DateTime dateTime) {
		return (List<HighlightsLowlights>) executeQuery(GET_ALL_HIGHLIGHTS_LOWLIGHTS_BY_WEEK_AND_YEAR, dateTime);
	}

	@SuppressWarnings("unchecked")
	public List<String> getAllProjectNamesByWeekAndYear(DateTime dateTime) {
		return (List<String>) executeQuery(GET_ALL_PROJECT_NAMES_BY_WEEK_AND_YEAR, dateTime);
	}
	
	@SuppressWarnings("unchecked")
	public List<ProjectReportByEmployee> getAllReportsByProjectNameAndWeekAndYear(String projectName, DateTime dateTime) {
		Query query = manager.createNamedQuery(GET_ALL_REPORTS_BY_PROJECT_NAME_AND_WEEK_AND_YEAR);
		query.setParameter("projectName", projectName);
		return (List<ProjectReportByEmployee>) executeQuery(query, dateTime);
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> getAllAvailableEngineersByWeekAndYear(DateTime dateTime) {
		return (List<Employee>) executeQuery(GET_ALL_AVAILABLE_ENGINEERS_BY_WEEK_AND_YEAR, dateTime);
	}
	
	@SuppressWarnings("unchecked")
	public List<ReportStatusByEmployee> getReportStatusForEachEmployeeByWeekAndYear(DateTime dateTime) {
		return (List<ReportStatusByEmployee>) executeQuery(GET_REPORT_STATUS_FOR_EACH_EMPLOYEE_BY_WEEK_AND_YEAR, dateTime);
	}
	
	public WeeklyReport getReportByEmployeeId(long employeeId, DateTime dateTime) {
		TypedQuery<WeeklyReport> query = manager.createNamedQuery(GET_REPORT_BY_EMPLOYEE_ID, WeeklyReport.class);
		query.setParameter("employeeId", employeeId);
		query.setParameter("week", dateTime.weekOfWeekyear().get());
		query.setParameter("year", dateTime.year().get());
		
		return query.getSingleResult();
	}
	
	private List<?> executeQuery(String queryName, DateTime dateTime) {
		Query query = manager.createNamedQuery(queryName);
		return executeQuery(query, dateTime);
	}
	
	private List<?> executeQuery(Query query, DateTime dateTime) {
		query.setParameter("week", dateTime.weekOfWeekyear().get());
		query.setParameter("year", dateTime.year().get());
		
		return query.getResultList();
	}

	@Transactional
	public void save(WeeklyReport weeklyReport) {
		manager.persist(weeklyReport);
		manager.flush();
	}
}