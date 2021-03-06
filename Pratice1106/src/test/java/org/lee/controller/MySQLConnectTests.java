package org.lee.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class MySQLConnectTests {

	@Test
	public void testConnect() throws Exception {
		
		//MySQL 5.6까지는  com.mysql.jdbc.Driver 사용가능
		//MySQL 6 이상시  com.mysql.cj.jdbc.Driver 사용가능
		Class<?> clz = Class.forName("com.mysql.cj.jdbc.Driver");
		
		log.info(clz);
		
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bitdb?serverTimezone=Asia/Seoul&useSSL=false",
				"bit04",
				"bit04");
		
		log.info(conn);
		
		conn.close();
	}
}
