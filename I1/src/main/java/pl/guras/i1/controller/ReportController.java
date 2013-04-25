package pl.guras.i1.controller;

import javax.servlet.http.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.guras.i1.dao.ReportDao;
import pl.guras.i1.security.SystemRole;
import pl.guras.i1.service.ReportService;
import pl.guras.i1.util.ReportDownloader;

@Controller
@Secured(SystemRole.ADMIN)
public class ReportController extends AbstractController {
	
	public static final String DOWNLOAD_REPORT = "downloadReport";

	public static final String WEEKLY_REPORT = "weeklyReport";

	public static final String REPORT_BY_EMPLOYEE = "reportByEmployee";

	public static final String REPORT_STATUSES = "reportStatuses";

	public static final String REPORT = "report";

	public static final String EMPLOYEE_ID = "employeeId";
	
	@Autowired
	private ReportService reportService;
	
	@Autowired
	private ReportDao reportDao;
	
	@RequestMapping(DOWNLOAD_REPORT)
	public void downloadReport(HttpServletRequest request, HttpServletResponse response) {
		ReportDownloader.downloadReport(request, response);
	}
	
	@RequestMapping(WEEKLY_REPORT)
	public String getWeeklyReport(Model model) {
		model.addAttribute(REPORT, reportService.generateReport(new DateTime()));
		return WEEKLY_REPORT;
	}
	
	@RequestMapping(REPORT_BY_EMPLOYEE)
	public String getReportByEmplyee(@RequestParam(EMPLOYEE_ID) long employeeId, Model model) {
		model.addAttribute(REPORT, reportDao.getReportByEmployeeId(employeeId, new DateTime()));
		return REPORT_BY_EMPLOYEE;
	}
	
	@RequestMapping(REPORT_STATUSES)
	public String getReportStatuses(Model model) {
		model.addAttribute(REPORT_STATUSES, reportDao.getReportStatusForEachEmployeeByWeekAndYear(new DateTime()));
		return REPORT_STATUSES;
	}
}