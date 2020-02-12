package com.example.form;

/**
 * ホテル検索フォーム.
 * 
 * @author yuuki
 *
 */
public class HotelForm {
	/** 価格 */
	private String price;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public Integer getIntPrice() {
		return Integer.parseInt(price);
	}
}
