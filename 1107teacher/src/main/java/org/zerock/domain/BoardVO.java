package org.zerock.domain;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BoardVO {
	
	private Integer bno;
	
	//@Size(min = 6, max = 10)
	private String title;
	
	@NotBlank
	private String content;
	
	private String writer;
	
	private Date regdate;

}
