package pl.guras.i1.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * @author mgorecki
 */
@Entity
@Table(name = "Weekly_Report")
@SuppressWarnings("serial")
@NamedQuery(name = WeeklyReport.GET_WEEKLY_REPORT_BY_WEEK_AND_YEAR, query = "SELECT wr FROM WeeklyReport AS wr WHERE wr.week = ?1 AND wr.year = ?2")
public class WeeklyReport implements Serializable {
	
	public static final String GET_WEEKLY_REPORT_BY_WEEK_AND_YEAR = "getWeeklyReportByWeekAndYear";
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String highlights;
	
	private String lowlights;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private Person user;
	
	@Column(name = "REPORT_WEEK")
	private int week;
	
	@Column(name = "REPORT_YEAR")
	private int year;
	
	@OneToMany(mappedBy = "weeklyReport", fetch = FetchType.EAGER)
	private List<ProjectReport> projectReports;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getHighlights() {
		return highlights;
	}
	
	public void setHighlights(String highlights) {
		this.highlights = highlights;
	}
	
	public String getLowlights() {
		return lowlights;
	}
	
	public void setLowlights(String lowlights) {
		this.lowlights = lowlights;
	}
	
	public Person getUser() {
		return user;
	}
	
	public void setUser(Person user) {
		this.user = user;
	}
	
	public int getWeek() {
		return week;
	}
	
	public void setWeek(int week) {
		this.week = week;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public List<ProjectReport> getProjectReports() {
		return projectReports;
	}
	
	public void setProjectReports(List<ProjectReport> projectReports) {
		this.projectReports = projectReports;
	}
}