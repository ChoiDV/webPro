package com.lec.ex1_string;

public class Friend {
	private String name;
	private String phone;
	private String birthday;
	public Friend() { }
	public Friend(String name, String phone, String birthday) {
		this.name = name;
		this.phone = phone;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "\n이  름 :" + name + "\n전  화 : " + phone + "\n생  일 : " + birthday;
	}
	public String getName() { return name; }
	public String getPhone() {return phone;}
	public String getBirthday() { return birthday; }
}
