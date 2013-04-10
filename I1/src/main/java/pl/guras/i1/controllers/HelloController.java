package pl.guras.i1.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.guras.i1.dao.Person;
import pl.guras.i1.dao.PersonDao;

/**
 * @author guras
 */
@Controller
public class HelloController {

	private static final String VIEW_WELCOME = "hello";
	private static final String VIEW_LOGIN = "login";

	@Autowired
	private PersonDao dao;
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();
		model.addAttribute("message", "joł : " + name);
		
		List<Person> users = dao.getPersons();
				
		model.addAttribute("users", users);
		return VIEW_WELCOME;
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
