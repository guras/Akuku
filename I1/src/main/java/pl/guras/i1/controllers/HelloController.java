package pl.guras.i1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.guras.i1.dao.PersonDao;
import pl.guras.i1.dao.ProjectDao;
import pl.guras.i1.dao.ReportDao;
import pl.guras.i1.entity.Color;
import pl.guras.i1.entity.Person;
import pl.guras.i1.entity.WeeklyReport;

@Controller
public class HelloController {

	private static final String VIEW_WELCOME = "hello";
	private static final String VIEW_LOGIN = "login";
	
	@Autowired
	private PersonDao dao;
	
	@Autowired
	private ReportDao reportDao;
	
	@Autowired
	private ProjectDao projectDao;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		Person loggedUser = getLoggedUser();

		WeeklyReport weeklyReport = new WeeklyReport();

		model.addAttribute("personalities", loggedUser.getFirstname()+ " " + loggedUser.getLastname());
		model.addAttribute("colors", Color.values());
		model.addAttribute(weeklyReport);
		model.addAttribute("projects", projectDao.getAll());
		return VIEW_WELCOME;
	}

	private Person getLoggedUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return dao.getPerson(user.getUsername());
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@Transactional
	public ModelAndView save(@ModelAttribute("weeklyReport") WeeklyReport weeklyReport) {
		weeklyReport.setUser(getLoggedUser());
		reportDao.save(weeklyReport);
		return new ModelAndView(VIEW_WELCOME, "aaa", "No zapisa�em");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return VIEW_LOGIN;
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginFail(ModelMap model) {
		model.addAttribute("error", "Błędny login lub hasło");
		return VIEW_LOGIN;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logut(ModelMap model) {
		return VIEW_LOGIN;
	}

	public PersonDao getDao() {
		return dao;
	}

	public void setDao(PersonDao dao) {
		this.dao = dao;
	}
}
