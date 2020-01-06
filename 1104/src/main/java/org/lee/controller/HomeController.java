package org.lee.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.lee.service.TimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.Setter;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Setter(onMethod_ = @Autowired) //_가 중요

//	public void setService(TimeService service) {
//		this.service = service;
//	} @Setter(onMethod_ = @Autowired)와 이 메서드와 같다.
	
	private TimeService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		model.addAttribute("serverTime", service.now() );
		
		return "home";
	}
	
}
