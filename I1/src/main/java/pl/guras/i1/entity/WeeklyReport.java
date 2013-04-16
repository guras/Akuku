package pl.guras.i1.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * @author mgorecki
 */
@Entity
@Table(name = "weekly_report")
@SuppressWarnings("serial")
@NamedQuery(name = WeeklyReport.GET_ALL_HIGHLIGHTS_LOWLIGHTS_BY_WEEK_AND_YEAR, query = "SELECT NEW pl.guras.i1.model.HighlightsLowlights(wr.highlights, wr.lowlights) FROM WeeklyReport AS wr WHERE wr.week = :week AND wr.year = :year")
public class WeeklyReport implements Serializable {
	
	public static final String GET_ALL_HIGHLIGHTS_LOWLIGHTS_BY_WEEK_AND_YEAR = "getAllHighlightsLowlightsByWeekAndYear";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String highlights;
	
	private String lowlights;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Person user;
	
	@Column(name = "report_week")
	private int week;
	
	@Column(name = "report_year")
	private int year;
	
	@OneToMany(mappedBy = "weeklyReport")
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