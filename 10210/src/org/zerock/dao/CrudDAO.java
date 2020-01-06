package org.zerock.dao;

import java.util.List;

import org.zerock.dto.PagingDTO;

public interface CrudDAO <V ,K>{
	
	public int insert(V vo);
	
	public V selectOne(K key);
	
	public boolean update(V vo);
	
	public boolean delete(K key);
	
	public List<V> getList(PagingDTO dto);
}
