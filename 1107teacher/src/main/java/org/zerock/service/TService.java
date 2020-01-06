package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.mapper.T1Mapper;
import org.zerock.mapper.T2Mapper;

import lombok.Setter;
import lombok.ToString;

@Service
@ToString
public class TService  { //트랜잭션 테스트
	
	@Setter(onMethod_ = @Autowired)
	private T1Mapper t1Mapper;
	
	@Setter(onMethod_ = @Autowired)
	private T2Mapper t2Mapper;
	
//	@Transactional
	public void write(String str) {
		
		t1Mapper.insert(str);
		
		int cur = t2Mapper.getCurrent();
		
		
		
		t2Mapper.insert(str);
		
	}
	
	

}
