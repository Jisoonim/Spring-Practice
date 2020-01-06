package org.lee.sample;

import lombok.Data;

@Data
public class Sample {

	private String s1,s2,s3;

	public Sample(String s1, String s2, String s3) {
		super();
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
	}
}
