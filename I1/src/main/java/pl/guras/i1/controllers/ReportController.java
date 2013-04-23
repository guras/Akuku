package pl.guras.i1.controllers;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.guras.i1.dao.ReportDao;
import pl.guras.i1.service.ReportService;

@Controller
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@Autowired
	private ReportDao reportDao;
	
	@RequestMapping("/report")
	public String getReport(Model model) {
		model.addAttribute("report", reportService.generateReport(new DateTime()));
		return "weeklyReport";
	}
	
	@RequestMapping("/reportStatuses")
	public String getReportStatuses(Model model) {
		model.addAttribute("reportStatuses", reportDao.getReportStatusForEachEmployeeByWeekAndYear(new DateTime()));
		return "reportStatuses";
	}
	
	@RequestMapping("/reportByEmployee")
	public String getReportByEmplyee(@RequestParam long employeeId, Model model) {
		model.addAttribute("report", reportDao.getReportByEmployeeId(employeeId, new DateTime()));
		return "reportByEmployee";
	}
}