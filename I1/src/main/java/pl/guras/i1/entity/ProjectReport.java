package pl.guras.i1.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author mgorecki
 */
@Entity
@Table(name = "Project_Report")
@SuppressWarnings("serial")
public class ProjectReport implements Serializable {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Enumerated(EnumType.STRING)
	private Color color;
	
	private Project project;
	
	@ManyToOne
	@JoinColumn(name = "WEEKLY_REPORT_ID", referencedColumnName = "ID") 
	private WeeklyReport weeklyReport;
	
	private String mainAchievements;
	
	private String doneLastWeek;
	
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