package org.zerock.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.security.CustomUser;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/sample/*")
@Controller
public class SampleController {

	@GetMapping("/all")
	public void doAll() {

		log.info("do all can access everybody");
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/member")
	public void doMember(Authentication auth) { //Principal보다 java.sercurity가 더 안전(Authentication)
		
		log.info(auth);
		
		CustomUser currentUser = (CustomUser)auth.getPrincipal();
		
		log.info(currentUser); //로그인 한 사용자 정보를 얻을 수 있다.

		log.info("logined member");
	}

	@GetMapping("/admin")
	public void doAdmin() {

		log.info("admin only");
	}

}
