package pl.guras.i1.controller;

import java.beans.PropertyEditorSupport;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.guras.i1.dao.*;
import pl.guras.i1.entity.*;
import pl.guras.i1.security.SystemRole;

@Controller
@Secured(SystemRole.USER)
public class UserReportManageController extends AbstractController {

	private static final Logger LOGGER = Logger.getLogger(UserReportManageController.class);
	
	public static final String SAVE = "save";

	public static final String WELCOME = "welcome";
	
	@Autowired
	private ReportDao reportDao;
	
	@Autowired
	private ProjectDao projectDao;
	
	@RequestMapping(value = WELCOME, method = RequestMethod.GET)
	public String createOrUpdateReport(Model model) {
		Person loggedUser = getLoggedUser();
		
		model.addAttribute(new WeeklyReport());
		model.addAttribute("personalities", loggedUser.getFirstname() + " " + loggedUser.getLastname());
		model.addAttribute("colors", Color.values());
		model.addAttribute("projects", projectDao.getAll());
		
		return WELCOME;
	}
	
	@RequestMapping(value = SAVE, method = RequestMethod.POST)
	@Transactional
	public ModelAndView save(@Valid @ModelAttribute("weeklyReport") WeeklyReport weeklyReport) {
		weeklyReport.setUser(getLoggedUser());
		reportDao.save(weeklyReport);
		return new ModelAndView(WELCOME, "aaa", "No zapisa³em");
	}
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Project.class, new PropertyEditorSupport() {
			
			@Override
			public void setAsText(String text) {
				Project project = projectDao.findById(Integer.parseInt(text));
				setValue(project);
			}

			@Override
			public String getAsText() {
				LOGGER.info("W ogole tu wchodze");
				Project p = (Project) getValue();
				LOGGER.info("W1");
				
				if (null != p) {
					LOGGER.info("W3");
					return String.valueOf(p.getId());
				}
				
				LOGGER.info("W2");
				return null;
			}
		});
	}
}