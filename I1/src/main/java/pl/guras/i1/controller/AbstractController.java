package pl.guras.i1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import pl.guras.i1.dao.PersonDao;
import pl.guras.i1.entity.Person;

public abstract class AbstractController {

	@Autowired
	protected PersonDao personDao;
	
	protected Person getLoggedUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return personDao.getPerson(user.getUsername());
	}
}