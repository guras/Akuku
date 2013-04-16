package pl.guras.i1.controllers;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.guras.i1.service.ReportService;

@Controller
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@RequestMapping("/report")
	public String getReport(Model model) {
		model.addAttribute("report", reportService.generateReport(new DateTime()));
		return "weeklyReport";
	}
}