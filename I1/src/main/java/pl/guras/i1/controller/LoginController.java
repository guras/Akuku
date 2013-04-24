package pl.guras.i1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import pl.guras.i1.entity.*;

@Controller
public class LoginController extends AbstractController {
	
	public static final String LOGIN = "login";

	public static final String LOGIN_SUCCEED = "loginSucceed";

	public static final String LOGIN_FAILED = "loginFailed";

	public static final String LOGOUT = "logout";

	@RequestMapping(value = LOGIN, method = RequestMethod.GET)
	public String login() {
		return LOGIN;
	}
	
	@RequestMapping(value = LOGIN_SUCCEED, method = RequestMethod.GET)
	public String loginSucceed() {
		Person loggedUser = getLoggedUser();
		String redirection = UrlBasedViewResolver.REDIRECT_URL_PREFIX;
		
		if (loggedUser.getTeamRole().equals(TeamRole.TEAM_LEADER)) {
			return redirection + ReportController.REPORT_STATUSES;
		}
		
		return redirection + UserReportManageController.WELCOME;
	}

	@RequestMapping(value = LOGIN_FAILED, method = RequestMethod.GET)
	public String loginFailed(Model model) {
		model.addAttribute("error", "B³êdny login lub has³o");
		return LOGIN;
	}

	@RequestMapping(value = LOGOUT, method = RequestMethod.GET)
	public String logut() {
		return LOGIN;
	}
}