package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;

public interface BoardMapper extends CrudMapper<BoardVO, Integer>, ListMapper<BoardVO> {

	public List<BoardVO> searchList(
			@Param("skip") int skip,
			@Param("amount") int amount,
			@Param("keyword") String keyword,
			@Param("type") String[] type
			);
	
	public int searchCount(
			@Param("keyword") String keyword,
			@Param("type") String[] type
			);
}
