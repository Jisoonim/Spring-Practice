package org.zerock.security;

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
		
		log.info("===================================");
		log.info(encoder);
		
		String text = "abcde";
		
		String en1 = encoder.encode(text);
		
		log.info(en1);
		
		String en2 = encoder.encode(text);
		
		log.info(en2);
	}
	
	@Test
	public void test2() {
		
		String text = "$2a$10$yiWVZXHtRShk.2DCQ/oEOehpGbGJYy8S1kRNIhI2CIc7zKRVMBV7O";
		
		boolean result = encoder.matches("abcde", text); //둘이 값이 같나 매칭. true or false
		
		log.info(result);
		
	}
	
}
