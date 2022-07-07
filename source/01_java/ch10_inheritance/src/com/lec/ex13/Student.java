package com.lec.ex13;

public class Student extends Person{
	private static int cntStudent=0;
	private String ban;
	public Student() { }
	public Student(String id, String name, String ban){
		super(id,name);
		this.ban = ban;
		++cntStudent;
		setNo("st10"+cntStudent);
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t(¹Ý)"+ban);
	}
	@Override
	public String infoString() {
		return super.infoString()+"\t(¹Ý)"+ban;
	}
}
