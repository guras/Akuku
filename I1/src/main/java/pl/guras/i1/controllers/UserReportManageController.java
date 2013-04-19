package pl.guras.i1.controllers;

import java.beans.PropertyEditorSupport;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.guras.i1.dao.PersonDao;
import pl.guras.i1.dao.ProjectDao;
import pl.guras.i1.dao.ReportDao;
import pl.guras.i1.entity.Color;
import pl.guras.i1.entity.Person;
import pl.guras.i1.entity.Project;
import pl.guras.i1.entity.WeeklyReport;

@Controller
public class UserReportManageController {

	private static final Logger LOG = Logger.getLogger(UserReportManageController.class);
	private static final String VIEW_WELCOME = "hello";
	private static final String VIEW_LOGIN = "login";
	@Autowired
	private PersonDao personDao;
	@Autowired
	private ReportDao reportDao;
	@Autowired
	private ProjectDao projectDao;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String createOrUpdateReport(ModelMap model) {
		Person loggedUser = getLoggedUser();

		// TODO tutaj bêdziemy pobieraæ
		WeeklyReport weeklyReport = null;
		if (null == weeklyReport) {
			weeklyReport = new WeeklyReport();
		} 

		model.addAttribute("personalities", loggedUser.getFirstname() + " " + loggedUser.getLastname());
		model.addAttribute("colors", Color.values());
		model.addAttribute(weeklyReport);
		model.addAttribute("projects", projectDao.getAll());
		return VIEW_WELCOME;
	}

	private Person getLoggedUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return personDao.getPerson(user.getUsername());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@Transactional
	public ModelAndView save(@Valid @ModelAttribute("weeklyReport") WeeklyReport weeklyReport) {
		weeklyReport.setUser(getLoggedUser());
		reportDao.save(weeklyReport);
		return new ModelAndView(VIEW_WELCOME, "aaa", "No zapisa³em");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return VIEW_LOGIN;
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginFail(ModelMap model) {
		model.addAttribute("error", "BÅ‚Ä™dny login lub hasÅ‚o");
		return VIEW_LOGIN;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logut(ModelMap model) {
		return VIEW_LOGIN;
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
				LOG.info("W ogole tu wchodze");
				Project p = (Project) getValue();
				LOG.info("W1");
				if (null != p) {
					LOG.info("W3");
					return String.valueOf(p.getId());
				}
				LOG.info("W2");
				return null;
				
			}
		});
	}
}
