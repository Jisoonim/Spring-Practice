package org.zerock.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SampleTask {
	
	//00초에 자동으로 메서드 호출해라.
	@Scheduled(cron = "58 * * * * *")
	public void doJob() {
		System.out.println("=========================0초입니다=========================");
		System.out.println("=========================0초입니다=========================");
		System.out.println("=========================0초입니다=========================");
		System.out.println("=========================0초입니다=========================");
		System.out.println("=========================0초입니다=========================");
		System.out.println("=========================0초입니다=========================");
		System.out.println("=========================0초입니다=========================");
		
	}

	
	
	
}
