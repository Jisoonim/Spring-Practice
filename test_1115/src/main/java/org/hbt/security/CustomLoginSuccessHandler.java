package org.hbt.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {

		log.warn("+++++++++++++++++++++++로그인에 성공하였습니다+++++++++++++++++++++++");

		List<String> roleNames = new ArrayList<>();

		auth.getAuthorities().forEach(authority -> {

			roleNames.add(authority.getAuthority());

		});

		log.warn("ROLE NAMES: " + roleNames);

		if (roleNames.contains("ROLE_ADMIN")) { //admin권한을 가진 아이디가 로그인하면 admin페이지로 바로 이동하게 한다.

			response.sendRedirect("/sample/admin");

			return;

		}

		if (roleNames.contains("ROLE_MEMBER")) { //member권한을 가진 아이디가 로그인하면 member페이지로 바로 이동하게 한다. 

			response.sendRedirect("/sample/member");

			return;

		}

		response.sendRedirect("/");

	}

}
