package com.lec.ex6_member;
public class Member {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String address;
	private String birth;
	private char   gender;
	public Member() { }
	public Member(String id, String pw, String name, String email, String address, String birth, char gender) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.gender = gender;
	}
	public String infoString() {
//		return String.format("아이디 = %s\n이름 = %s\n이메일 = %s\n"+
//							 "주소 = %s\n생일 = %s\n성별 = %c\n", 
//							 id, name, email, address, birth, gender);
		String result = "아이디 = "+ id +"\n";
		result += "이름 = " + name + "\n";
		result += "이메일 = " + email + "\n";
		result += "주소 = " + address + "\n";
		result += "생일 = " + birth + "\n";
		result += "성별 = " + gender + "\n";
		return result;
	}
}
