package com.lec.hrd.dto;

public class SalesDto {
	private int custno;
	private String custname;
	private String gradename;
	private int price;
	public SalesDto() {}
	public SalesDto(int custno, String custname, String gradename, int price) {
		this.custno = custno;
		this.custname = custname;
		this.gradename = gradename;
		this.price = price;
	}
	public int getCustno() {
		return custno;
	}
	public void setCustno(int custno) {
		this.custno = custno;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getGradename() {
		return gradename;
	}
	public void setGradename(String gradename) {
		this.gradename = gradename;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "SalesDto [custno=" + custno + ", custname=" + custname + ", gradename=" + gradename + ", price=" + price
				+ "]";
	}
}
