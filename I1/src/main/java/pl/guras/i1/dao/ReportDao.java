package pl.guras.i1.dao;

import java.util.List;
import javax.persistence.*;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.guras.i1.entity.WeeklyReport;

@Repository
public class ReportDao {

	@PersistenceContext
	private EntityManager entityManager;

	public List<WeeklyReport> getWeeklyReportByWeekAndYear(DateTime dateTime) {
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void save(WeeklyReport weeklyReport) {
		entityManager.persist(weeklyReport);
		entityManager.flush();
	}
}