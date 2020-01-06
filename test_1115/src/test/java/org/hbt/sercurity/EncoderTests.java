package org.hbt.sercurity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/security-context.xml")
@Log4j

public class EncoderTests {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	public void test1() {
		log.info("++++++++++++++++++++++++++++");
		log.info(encoder);
		
		String text = "aaaaa";
		
		String en1 = encoder.encode(text);
		
		log.info("aaaaa를 인코딩하면 : " + en1);
		
		String en2 = encoder.encode(text);
		
		log.info("aaaaa를 다시 인코딩하면 : " + en2);
		//이 테스트를 통해 "aaaaa"를 계속 인코딩해도 다른값이 나온다는 걸 알수있다.(CSRF TOKEN)
		
	}
	
	@Test
	public void test2() {
		
		String text = "$2a$10$65yQOfHKx4.cnSj0.AGInujIno17pVYHhsdWdnpe14K7HU07ffb1.";
		
		boolean result = encoder.matches("aaaaa", text);
		
		log.info(result);
		
		//이 테스트를 통해 TOKEN값과 "aaaaa"의 값이 같다는걸 알 수 있다.
	}

}
