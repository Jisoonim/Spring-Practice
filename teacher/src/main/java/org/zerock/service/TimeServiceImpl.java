package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.mapper.TimeMapper;

import lombok.Setter;

@Service
public class TimeServiceImpl implements TimeService {

	@Setter(onMethod_ =  @Autowired)
	private TimeMapper timeMapper;

	@Override
	public String now() {

		return timeMapper.getTime2();
	}

}
