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
import pl.guras.i1.dao.ReportDao;
import pl.guras.i1.entity.Color;
import pl.guras.i1.entity.Person;
import pl.guras.i1.entity.Project;
import pl.guras.i1.entity.WeeklyReport;

/**
 * @author guras
 */
@Controller
public class HelloController {

	private static final String VIEW_WELCOME = "hello";
	private static final String VIEW_LOGIN = "login";
	@Autowired
	private PersonDao dao;
	@Autowired
	private ReportDao reportDao;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Person loggedUser = dao.getPerson(user.getUsername());

		WeeklyReport weeklyReport = new WeeklyReport();

		model.addAttribute("personalities", loggedUser.getName() + " " + loggedUser.getSurname());
		model.addAttribute("colors", Color.values());
		model.addAttribute("projects", Project.values());
		model.addAttribute(weeklyReport);
		return VIEW_WELCOME;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("weeklyReport") WeeklyReport weeklyReport) {
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
