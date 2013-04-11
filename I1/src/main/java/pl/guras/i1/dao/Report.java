package pl.guras.i1.dao;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author mgorecki
 */
@Entity
@Table(name = "report")
public class Report {
    
    Person user;
    int week;
    int year;
    Color color;
    @OneToMany
    Project project;
    String highlights;
    String lowlights;
    String mainAchievements;
    String doneLastWeek;
    String nextSteps;
    String edc;
    String etc;
}
