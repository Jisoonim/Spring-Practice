package org.zerock.dto;

public class PagingDTO {
	
	private int page;
	private int amount;
	
	public PagingDTO() {
		this.page = 1;
		this.amount = 10;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if( page <=0 ) return;
		
		this.page = page;
	}

	@Override
	public String toString() {
		return "PagingDTO [page=" + page + ", amount=" + amount + "]";
	}

	
	
	
	
	
}
