package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/*")
public class HelloController {
	
	
	public String Hello() {
		return "Hello World";
	}

}
