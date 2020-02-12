package com.example.form;

/**
 * 衣類検索フォーム
 * 
 * @author yuuki
 *
 */
public class ClothForm {
	/** 性別 */
	private String gender;
	
	
	/**　色 */
	private String color;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public Integer getIntGender() {
		return Integer.parseInt(gender);
	}
}
