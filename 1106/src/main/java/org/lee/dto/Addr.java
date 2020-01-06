package org.lee.dto;

public class Addr {

	private String zip, tel;

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Addr [zip=" + zip + ", tel=" + tel + "]";
	}
	
}
