package org.zerock.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.dto.PageDTO;
import org.zerock.dto.PageMaker;
import org.zerock.service.BoardService;
import org.zerock.service.TestService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController {
	
	@Setter(onMethod_ = { @Autowired }  )
	private BoardService service;
	
	@Setter(onMethod_ = { @Autowired }  )
	private TestService testService;

	@GetMapping("/register") //register = 게시물 등록페이지
	public void registerGET() {
		log.info("get register......");
	}
	
	@GetMapping("/read")
	public void read(@ModelAttribute("dto") PageDTO dto, Model model) {
		
		model.addAttribute("board", service.findByBno(dto.getBno()));
		
		log.info("read get................");
		
	}
	
	@PostMapping(value = "URI", consumes = "application/json")
	public @ResponseBody ResponseEntity<Boolean> registerRest
			(@RequestBody BoardVO vo) {//위에 에너테이션을 쓰는것보다 public뒤에 쓰는걸 선호.
		
		return null;
	}
	
	@PostMapping("/register")
	public String registerPost(@ModelAttribute("vo") @Valid BoardVO vo,  BindingResult bind, RedirectAttributes rttr) {
		log.info("post register......");
		log.info(vo);
		
		if(bind.hasErrors()) {
			log.info("error exists");
			return "/board/register";
		}
		
		
		
		boolean result = service.register(vo);
		
		log.info("result: " + result);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		log.info("====================");
		
		return "redirect:/board/list";
		
	}
	
	@GetMapping("/list") // list = 전체게시물 출력
	public void list(PageDTO dto, Model model ) {
		log.info("get list......");
		
		log.info(testService.getClass().getName());
		log.info(service.getClass().getName());
		
		testService.doA();
		
		model.addAttribute("list", service.getList(dto));
		
		int total = service.getListCount(dto);
		
		PageMaker pg = new PageMaker(dto, total);
		
		model.addAttribute("pg", pg);
		
	}
	
	
}









