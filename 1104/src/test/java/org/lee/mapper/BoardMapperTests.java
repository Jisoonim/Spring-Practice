package org.lee.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lee.domain.BoardVO;
import org.lee.dto.PageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class BoardMapperTests {
	@Autowired
	private BoardMapper mapper; 
	
	@Test
	public void testSearchList() {
		
		PageDTO dto = new PageDTO();
		dto.setPage(1);
		dto.setAmount(10);
		dto.setKeyword("40");
		dto.setType("TC"); //제목이나 내용
		
		List<BoardVO> list = mapper.searchList(dto);
										//1, //page
										//20, //amount
										//"내용...", 
										//new String[] {"T","W","C"}); //T는 title(제목), W는 writer(작성자)(제목+작성자로 검색하기)
		
		list.forEach(vo -> {
			log.info(vo); //vo=게시물 내용
		});
		
		log.info("============================");
		
		int count = mapper.searchCount(dto); //첫번째 매개변수에 검색어 입력, 제목+작성자+내용으로 검색하기.
											//"내용....", new String[] {"T","W","C"}
		
		log.info("++++++++++++++++++++++++++++++++");
		
		log.info("COUNT: " + count);
	}
	
	@Test
	public void testSelectPaging() {
		
		mapper.selectList(10, 0).forEach(vo -> {
			log.info(vo);
			
		});
	}
	
	@Test
	public void testInsert() {
		
		IntStream.range(1, 101).forEach(i -> {
			BoardVO vo = new BoardVO();
			vo.setTitle("제목......" + i);
			vo.setContent("내용......" + i);
			vo.setWriter("user" + i);
			int count = mapper.insert(vo);
			log.info(count);
		});
	}
	
	@Test
	public void test1() {
		log.info(mapper);
		assertNotNull(mapper);
	}
	
}
