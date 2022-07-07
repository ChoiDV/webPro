package com.lec.ex13;
public class Person {
	private String no;
	private String id;
	private String name;
	public Person() { }
	public Person(String id, String name){
		this.id = id;
		this.name = name;
	}
	public void print(){
		if (id.length() < 4) {
			System.out.print("(번호)"+no+"\t(ID)"+id+"\t\t(이름):"+name);
		}else {
			System.out.print("(번호)"+no+"\t(ID)"+id+"\t(이름):"+name);
		}
	}
	public String infoString() {
		return "(번호)"+no+"\t(ID)"+id+"\t(이름):"+name;
	}
	public String getNo() {return no;}
	public String getId() {return id; }
	public String getName() {return name;}
	public void setNo(String no) {this.no = no; }
	public void setId(String id) {this.id = id; }
	public void setName(String name) {this.name = name;}
}
