package com.lec.exam;

public class CustomerDto {
	private int id;
	private String phone;
	private String name;
	private int point;
	// insert용
	public CustomerDto(String phone, String name, int point) {
		this.phone = phone;
		this.name = name;
		this.point = point;
	}
	// select용
	public CustomerDto(int id, String phone, String name, int point) {
		this.id = id;
		this.phone = phone;
		this.name = name;
		this.point = point;
	}
	@Override
	public String toString() {
		return id + ". " + name + "\t" +phone+ "\t" + point;
	}
	// DAO 에서 쓸 예정
	public int getId() {return id;}
	public String getPhone() {return phone;}
	public String getName() {return name;}
	public int getPoint() {return point;}
}
