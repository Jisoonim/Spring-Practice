package org.lee.mapper;

import java.util.List;

public interface ListMapper<E> {
	
	public List<E> selectList(int skip);

}
