package pl.guras.i1.entity;

import static pl.guras.i1.entity.WeeklyReport.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.joda.time.DateTime;

@Entity
@Table(name = "weekly_report")
@SuppressWarnings("serial")
@NamedQueries
({
	@NamedQuery(name = GET_ALL_HIGHLIGHTS_LOWLIGHTS_BY_WEEK_AND_YEAR, query = "SELECT NEW pl.guras.i1.model.HighlightsLowlights(wr.highlights, wr.lowlights) FROM WeeklyReport AS wr WHERE wr.week = :week AND wr.year = :year"),
	@NamedQuery(name = GET_REPORT_STATUS_FOR_EACH_EMPLOYEE_BY_WEEK_AND_YEAR, query = "SELECT NEW pl.guras.i1.model.ReportStatusByEmployee(u.id, u.firstname, u.lastname, u.teamRole, CASE WHEN (SELECT COUNT(r) FROM WeeklyReport AS r WHERE r.user.id = u.id AND r.week = :week AND r.year = :year) > 0 THEN TRUE ELSE FALSE END) FROM WeeklyReport AS wr RIGHT OUTER JOIN wr.user AS u"),
	@NamedQuery(name = GET_REPORT_BY_EMPLOYEE_ID, query = "SELECT wr FROM WeeklyReport AS wr FETCH JOIN wr.user AS u FETCH JOIN wr.projectReports AS pr WHERE u.id = :employeeId AND wr.week = :week AND wr.year = :year")
})
public class WeeklyReport implements Serializable {
	
	public static final String GET_ALL_HIGHLIGHTS_LOWLIGHTS_BY_WEEK_AND_YEAR = "getAllHighlightsLowlightsByWeekAndYear";
	
	public static final String GET_REPORT_STATUS_FOR_EACH_EMPLOYEE_BY_WEEK_AND_YEAR = "getReportStatusForEachEmployeeByWeekAndYear";
	
	public static final String GET_REPORT_BY_EMPLOYEE_ID = "getReportByEmployeeId";
	
	public WeeklyReport() {
		DateTime dateTime = new DateTime();

		this.week = dateTime.getWeekOfWeekyear();
		this.year = dateTime.getYear();
		this.projectReports = new LinkedList<ProjectReport>();
		projectReports.add(new ProjectReport());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(max = 4096)
	private String highlights;
	
	@NotNull
	@Size(max = 4096)
	private String lowlights;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Person user;
	
	@Column(name = "report_week")
	private int week;
	
	@Column(name = "report_year")
	private int year;
	
	@OneToMany(mappedBy = "weeklyReport", cascade = CascadeType.ALL)
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