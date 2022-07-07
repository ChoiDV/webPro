package com.lec.ex5_personinfo;

public class PersonInfo {
	private String name;
	private int age;
	private char gender;
	public PersonInfo() { }
	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public void print() {//이름 = 홍길동	 나이 = 20	성별 = m 
		System.out.println("이름 = "+name+"\t나이 = "+age+"\t성별="+gender);
	}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	public char getGender() {return gender;}
	public void setGender(char gender) {this.gender = gender;}
}
