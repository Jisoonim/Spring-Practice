package org.zerock.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testSearchList() {
		
		List<BoardVO> list = mapper.searchList(
				0, 
				10, 
				"제목", 
				new String[]{"T","W"});
		
		list.forEach(vo -> {
			log.info(vo);
		});
		
		log.info("=========================");
		
		int count = mapper.searchCount("400", new String[]{"T","W"});
		
		log.info("COUNT: " + count);
		
	}
	
	@Test
	public void testSelectPaging() {
		
		mapper.selectList(10, 20).forEach(vo -> {
			log.info(vo);
		});
	}
	
	@Test
	public void testInsert() {
		
		IntStream.range(400,450 ).forEach(i -> {
			BoardVO vo = new BoardVO();
			vo.setTitle("����...." + i);
			vo.setContent("����........." + i);
			vo.setWriter("user"+i);
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
