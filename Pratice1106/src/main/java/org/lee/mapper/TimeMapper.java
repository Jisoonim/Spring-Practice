package org.lee.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("select now()") //mySQL�ۼ�(select sysdate from dual�� ����)
	public String getTime1();
	
	public String getTime2();
}
