package org.zerock.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {
	
	@GetMapping("/customLogout")
	public void customLogout() {
		log.info("custom Logout.................");
	}

	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {

		log.info("접근 권한이 없습니다...........");

		log.info(auth.getCredentials());

		model.addAttribute("msg", "권한이 충분하지 않습니다.");

	}

	@GetMapping("/customLogin")

	public void loginInput(String error, String logout, Model model) {

		log.info("error: " + error);

		log.info("logout: " + logout);

		if (error != null) {

			model.addAttribute("error", "Login Error Check Your Account");

		}

		if (logout != null) {

			model.addAttribute("logout", "Logout!!");

		}

	}

}
