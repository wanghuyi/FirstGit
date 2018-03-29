package com.offcn.pojo;

public class Vegetables {

	//蔬菜
	private String shucai;
	private String minprice;
	private String middle_rate;
	private String max_rate;
	private String guige;
	private String danwei;
	private String date;
	public String getShucai() {
		return shucai;
	}
	public void setShucai(String shucai) {
		this.shucai = shucai;
	}
	public String getMinprice() {
		return minprice;
	}
	public void setMinprice(String minprice) {
		this.minprice = minprice;
	}
	public String getMiddle_rate() {
		return middle_rate;
	}
	public void setMiddle_rate(String middle_rate) {
		this.middle_rate = middle_rate;
	}
	public String getMax_rate() {
		return max_rate;
	}
	public void setMax_rate(String max_rate) {
		this.max_rate = max_rate;
	}
	public String getGuige() {
		return guige;
	}
	public void setGuige(String guige) {
		this.guige = guige;
	}
	public String getDanwei() {
		return danwei;
	}
	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Vegetables [shucai=" + shucai + ", minprice=" + minprice + ", middle_rate=" + middle_rate
				+ ", max_rate=" + max_rate + ", guige=" + guige + ", danwei=" + danwei + ", date=" + date + "]";
	}
	
	
}
