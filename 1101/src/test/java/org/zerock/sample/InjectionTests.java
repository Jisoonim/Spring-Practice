package org.zerock.sample;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class InjectionTests {
	
	@Autowired //기도해라.
	private DataSource ds;
	
	@Autowired
	TimeMapper timeMapper;
	
	@Test
	public void testTime() {
		log.info("--------------------------------");
		log.info(timeMapper.getTime());
	}
	
	@Test
	public void testDS() {
		log.info(ds);
		
		try {
		Connection con = ds.getConnection();
			log.info(con);
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		}
	
	@Test
	public void test1() {
		log.info("AAAAAAAAAAAAAAAAAA");
	}

}
