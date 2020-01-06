package org.lee.controller;

import java.util.List;

import org.lee.domain.BoardVO;
import org.lee.dto.PageDTO;
import org.lee.mapper.BoardMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
@AllArgsConstructor
public class BoardController {

	private BoardMapper boardMapper;

	@GetMapping("/register")
	public void registerGET() {

	}

	@GetMapping("/list")
	public void list(@ModelAttribute("dto")PageDTO dto,//파라미터에 사용된다. 전달된 데이터를 다시 전달하고싶을때 사용
//			@RequestParam(defaultValue = "1") int page,
//			@RequestParam(defaultValue = "10") int amount,
//			String keyword, 
//			String[] types,
			Model model) { // ��Ƽ� ����������� model�� ����Ѵ�.

		log.info(dto);
		
//		log.info("..............." + page);
//		log.info("..............." + amount);
//		log.info("..............." + keyword);
//		log.info("..............." + Arrays.toString(types));

//		log.info("................" + page);
//		log.info("" + boardMapper);
//
		List<BoardVO> list = boardMapper.searchList(dto);

		model.addAttribute("list", list);

		log.info(list);

	}
}
