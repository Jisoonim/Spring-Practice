package org.zerock.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}) 
@Log4j
public class BoardControllerTests {

	 @Setter(onMethod_ = {@Autowired} )
	 private WebApplicationContext ctx;

	 private MockMvc mockMvc;
	 
	 @Before
	 public void ready() {
		 
		 log.info("ready..........mock");
		 this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build(); 
		 log.info(mockMvc);
	 }
	 
	 @Test
	 public void test1() throws Exception {
		 log.info("test1....................");
		 
		 log.info(
				 mockMvc.perform(
				 get("/board/list")
				.param("page", "1")
	 )
				 .andReturn()
				 .getModelAndView()
				 .getModel()
				 );
	 }
	
	 @Test
	 public void test2() {
		 log.info("test2....................");
	 }
	 
	 @Test
	 public void testRegister() throws Exception{

	 String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
			 .param("title", "mockMvc테스트")
			 .param("content", "테스트 내용")
			 .param("writer", "user17")
			 ).andReturn().getModelAndView().getViewName();

	 	log.info(resultPage);

	 } 

	 
	 
}
