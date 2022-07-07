package com.lec.ex3_exceptionExs;

public class Ex01_NullPoint {
	public static void main(String[] args) {
		String greeting = "Hello";
		System.out.println(greeting.toUpperCase()); // 대문자로
		greeting = null;
		System.out.println(greeting.toUpperCase());
	}
}
