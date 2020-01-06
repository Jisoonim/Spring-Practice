package org.lee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.lee.domain.BoardVO;
import org.lee.dto.PageDTO;

public interface BoardMapper extends CrudMapper<BoardVO, Integer> ,ListMapper<BoardVO> {

	public List<BoardVO> searchList(PageDTO dto);
//			(@Param("skip") int skip,
//			@Param("amount") int amount,
//			@Param("keyword") String keyword,
//			@Param("type") String[] type);
			
			
	
	public int searchCount(PageDTO dto);
//			@Param("keyword") String keyword,
//			@Param("type") String[] type
//			);
}
