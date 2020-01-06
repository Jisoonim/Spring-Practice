package org.zerock.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.zerock.domain.PositionDTO;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {
	
	private static int count  = 100;
	
		@CrossOrigin //걸면 웹스톰에서도 접속가능하나, 에너테이션 선언을 안하면 들어갈수 없다
		@GetMapping("/ex1")
		public ResponseEntity<String> ex1() {
		
			log.info("sample ex1....get....");
			
			return new ResponseEntity<String>("EX1" + ++count,HttpStatus.OK);
			
		}
		
		@GetMapping("/ex2")
		public ResponseEntity<String> ex2() {
		
			log.info("sample ex2....get....");
			
			RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
			
			ResponseEntity<String> result = template.getForEntity(
					"http://10.10.10.140:8080/sample/ex1", 
								String.class);
			
			return result;
			
		}
		
	  //@CrossOrigin
		@PostMapping("/doB")
		public ResponseEntity<PositionDTO> doB(@RequestBody PositionDTO dto) {
			
		RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
		
				PositionDTO result = template.postForObject(
							"http://10.10.10.140:8080/sample/doA", 
										dto,PositionDTO.class);
 
				return new ResponseEntity<>(result, HttpStatus.OK);
				
		}

	//@CrossOrigin
	@PostMapping("/doA")
	public ResponseEntity<PositionDTO> doA(@RequestBody PositionDTO dto) {

		log.info(dto);
		
		return new ResponseEntity<>(dto, HttpStatus.OK);

	}

}
