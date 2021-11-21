package com.issuemgmtsystem.controller;

import java.util.Set;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.issuemgmtsystem.model.Role;
import com.issuemgmtsystem.model.User;
import com.issuemgmtsystem.model.UserPrincipal;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
	
	
	@GetMapping("/homepage")
	public String main(Model model, @RequestParam(required = false) String username,
			@RequestParam(required = false) String password, @CurrentSecurityContext SecurityContext ctx) {
		String sessionId = ((WebAuthenticationDetails) ctx.getAuthentication().getDetails()).getSessionId();
		System.out.println("Session-ID: " + sessionId);
		UserPrincipal userPrincipal = ((UserPrincipal) ctx.getAuthentication().getPrincipal());
		log.info(userPrincipal.toString());
		return "homepage";
	}

	@GetMapping("/")
	public String login(Model model, @CurrentSecurityContext SecurityContext ctx) {
		if (ctx.getAuthentication().isAuthenticated())
			return "homepage";
		else {
			log.info("Pls Log in");
			return "login";
		}
	}

	@GetMapping("/login")
	public String login(@CurrentSecurityContext SecurityContext ctx) {
		System.out.println(ctx.getAuthentication());
		return "login";
	}

	@GetMapping("/perform_invalid")
	public ModelAndView sessionInvalid(HttpSession session) {
		session.invalidate();
		try {
			session.invalidate();
			log.info("Session invalidation failed");
		} catch (Exception e) {
			log.info("Session invalidated successfully");
		}
		ModelAndView mv = new ModelAndView("/login");
		mv.addObject("invalid", true);
		return mv;
	}
	
	@GetMapping("/GetCurrentUser")
	public String editUser(Model model,@AuthenticationPrincipal UserPrincipal userPrincipal) {
	    User user = userPrincipal.getUser();
	    Set<Role> listRoles = user.getRoles();
	    model.addAttribute("currentUser", user);
	    model.addAttribute("currentUserRoles", listRoles);
	    return "user";
	}
}
