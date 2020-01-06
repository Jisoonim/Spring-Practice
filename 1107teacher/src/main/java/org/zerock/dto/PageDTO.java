package org.zerock.dto;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Data
public class PageDTO {

	private Integer bno;
	private int page = 1;
	private int amount = 10;
	private String keyword;
	private String type;
	
	public String[] getTypes() {
		if(type == null || type.trim().length() == 0) {
			return null;
		}
		return type.split("");
	}

	public int getSkip() {
		
		return (page -1) * amount;
	}
	
	public String getLink(Integer bno) {
		
		String result = "";
		
		result = UriComponentsBuilder.newInstance()
				.queryParam("bno", bno)
				.queryParam("keyword", "서울 종로 종로1가")
				.build().getQuery();
		
		return result;
	}
}

