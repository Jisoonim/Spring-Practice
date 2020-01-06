package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface T2Mapper {

	@Select("select last_insert_id()")
	public int getCurrent();
	
	@Insert("insert into tbl_t2 (targetno, ex) values( last_insert_id(), #{str})")
	 public boolean insert(String str);
}
