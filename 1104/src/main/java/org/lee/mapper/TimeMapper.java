package org.lee.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("select now()") //mySQL작성(select sysdate from dual과 같음)
	public String getTime1();
	
	public String getTime2();
}
