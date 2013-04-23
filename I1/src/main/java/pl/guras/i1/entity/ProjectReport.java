package pl.guras.i1.entity;

import static pl.guras.i1.entity.ProjectReport.*;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "project_report")
@SuppressWarnings("serial")
@NamedQueries
({
	@NamedQuery(name = GET_ALL_PROJECT_NAMES_BY_WEEK_AND_YEAR, query = "SELECT DISTINCT p.name FROM ProjectReport AS pr INNER JOIN pr.project AS p INNER JOIN pr.weeklyReport AS wr WHERE wr.week = :week AND wr.year = :year"),
	@NamedQuery(name = GET_ALL_REPORTS_BY_PROJECT_NAME_AND_WEEK_AND_YEAR, query = "SELECT NEW pl.guras.i1.model.ProjectReportByEmployee(u.firstname, u.lastname, u.teamRole, pr.color, pr.mainAchievements, pr.doneLastWeek, pr.nextSteps, pr.edc, pr.etc) FROM ProjectReport AS pr INNER JOIN pr.project AS p INNER JOIN pr.weeklyReport AS wr INNER JOIN wr.user AS u WHERE p.name = :projectName AND wr.week = :week AND wr.year = :year"),
	@NamedQuery(name = GET_ALL_AVAILABLE_ENGINEERS_BY_WEEK_AND_YEAR, query = "SELECT NEW pl.guras.i1.model.Employee(u.firstname, u.lastname, u.teamRole) FROM ProjectReport AS pr INNER JOIN pr.project AS p INNER JOIN pr.weeklyReport AS wr INNER JOIN wr.user AS u WHERE p IS NULL AND wr.week = :week AND wr.year = :year")
})
public class ProjectReport implements Serializable {
	
	public static final String GET_ALL_PROJECT_NAMES_BY_WEEK_AND_YEAR = "getAllProjectNamesByWeekAndYear";
	
	public static final String GET_ALL_REPORTS_BY_PROJECT_NAME_AND_WEEK_AND_YEAR = "getAllReportsByProjectNameAndWeekAndYear";
	
	public static final String GET_ALL_AVAILABLE_ENGINEERS_BY_WEEK_AND_YEAR = "getAllAvailableEngineersByWeekAndYear";

	public ProjectReport() {
	}
	
	public ProjectReport(WeeklyReport wr) {
		this.color = Color.GREEN;
		this.weeklyReport = wr;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Enumerated(EnumType.STRING)
	private Color color;
	
	@OneToOne
	@JoinColumn(name = "project_id", referencedColumnName = "id")
	private Project project;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "weekly_report_id", referencedColumnName = "id") 
	private WeeklyReport weeklyReport;
	
	@Column(name = "main_achievements")
	private String mainAchievements;
	
	@Column(name = "done_last_week")
	private String doneLastWeek;
	
	@Column(name = "next_steps")
	private String nextSteps;
	
	private String edc;
	
	private String etc;
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}
	
	public String getMainAchievements() {
		return mainAchievements;
	}
	
	public void setMainAchievements(String mainAchievements) {
		this.mainAchievements = mainAchievements;
	}
	
	public String getDoneLastWeek() {
		return doneLastWeek;
	}
	
	public void setDoneLastWeek(String doneLastWeek) {
		this.doneLastWeek = doneLastWeek;
	}
	
	public String getNextSteps() {
		return nextSteps;
	}
	
	public void setNextSteps(String nextSteps) {
		this.nextSteps = nextSteps;
	}
	
	public String getEdc() {
		return edc;
	}
	
	public void setEdc(String edc) {
		this.edc = edc;
	}
	
	public String getEtc() {
		return etc;
	}
	
	public void setEtc(String etc) {
		this.etc = etc;
	}
	
	public WeeklyReport getWeeklyReport() {
		return weeklyReport;
	}
	
	public void setWeeklyReport(WeeklyReport weeklyReport) {
		this.weeklyReport = weeklyReport;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}