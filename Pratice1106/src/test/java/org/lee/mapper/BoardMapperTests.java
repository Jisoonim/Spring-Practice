package org.lee.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lee.domain.BoardVO;
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
	public void testSelectPaging() {

		mapper.selectList(0).forEach(vo -> {
			log.info(vo);
		});
	}

	@Test
	public void testInsert() {
		IntStream.range(102, 201).forEach(i -> {
			BoardVO vo = new BoardVO();
			vo.setTitle("제목......." + i);
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
