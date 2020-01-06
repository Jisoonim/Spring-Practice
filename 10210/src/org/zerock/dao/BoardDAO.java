package org.zerock.dao;

import org.zerock.domain.BoardVO;

public interface BoardDAO<T> extends CrudDAO<BoardVO, Long>{
	public int getCount();
}
