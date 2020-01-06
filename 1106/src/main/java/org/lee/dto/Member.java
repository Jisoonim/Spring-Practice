package org.lee.dto;

import java.util.List;

public class Member {
	
	private String uid, upw;
	private List<Addr> addr;
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public List<Addr> getAddr() {
		return addr;
	}
	public void setAddr(List<Addr> addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Member [uid=" + uid + ", upw=" + upw + ", addr=" + addr + "]";
	}
	
	

}

