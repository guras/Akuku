package pl.guras.i1.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author mgorecki
 */
@Entity
@Table(name = "Weekly_Report")
public class WeeklyReport implements Serializable {

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
	
	@OneToMany(fetch = FetchType.LAZY)
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
