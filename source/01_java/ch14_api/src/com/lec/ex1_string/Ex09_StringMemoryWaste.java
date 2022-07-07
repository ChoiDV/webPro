package com.lec.ex1_string;
// 스트링 변수의 값을 바꿀 때마다 객체가 새롭게 생성됩니다. 
public class Ex09_StringMemoryWaste {
	public static void main(String[] args) {
		String str1 = "Hello";
		String str2 = "Hello";
		System.out.println(str1==str2 ? "같은 주소" : "다른 주소");
		System.out.println("str1의 해쉬코드 : "+str1.hashCode());
		System.out.println("str2의 해쉬코드 : "+str2.hashCode());
		str1 = "Hello~";
		System.out.println("str1의 해쉬코드(변경1후) : "+str1.hashCode());
		System.out.println(str1==str2? "같은주소":"다른 주소");
		str1 = "Hello~~";
		System.out.println("str1의 해쉬코드(변경2후) : "+str1.hashCode());
		str1 = "Hello~~~";
		System.out.println("str1의 해쉬코드(변경3후) : "+str1.hashCode());
	}
}
