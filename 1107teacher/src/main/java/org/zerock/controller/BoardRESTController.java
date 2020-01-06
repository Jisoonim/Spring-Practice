package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.BoardVO;
import org.zerock.dto.PageDTO;
import org.zerock.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RequestMapping("/board2/*")
@RestController //Controller가 REST 방식을 처리하기 위한 것임을 명시
@Log4j
public class BoardRESTController {
	
	@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	
	@PostMapping("/")
	public ResponseEntity<Boolean> register(@RequestBody BoardVO vo) {//에러가 많이나는곳(415번 에러가 난다면 무조건 json문제,.)
		//@ResponseBody : 일반적인 JSP와 같은 뷰로 전달되는게 아니라 데이터 자체를 전달하기 위한 용도
		//boolean 타입 사용했었음.(11.11)
		log.info(vo);
		
		//return true;
		//return service.register(vo);
		
		boolean success =  service.register(vo);
		ResponseEntity<Boolean> result  = new  ResponseEntity<Boolean>(success, HttpStatus.CREATED);
		
		return result;
	}
	
	@GetMapping("/{bno}") //브레이스로 감쌌다->변수다(json)
	public BoardVO read(@PathVariable("bno") Integer bno) {//pathVariable: URL경로에 있는 값을 파라미터로 추출하려고 할 때 사용
		
		return service.findByBno(bno);
		
	}
	
	@CrossOrigin
	@GetMapping("/list1")
	public List<BoardVO> list1() {
		
		PageDTO dto = new PageDTO();
		
		return service.getList(dto);
		
	}
	
}
