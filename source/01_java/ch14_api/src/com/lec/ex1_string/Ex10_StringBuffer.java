package com.lec.ex1_string;
public class Ex10_StringBuffer {
	public static void main(String[] args) {
		StringBuilder strBuilder = new StringBuilder("abc");
		System.out.println("해쉬코드 결과 : "+strBuilder.hashCode());
		System.out.println("strBuilder : "+strBuilder);
		strBuilder.append("def"); // 기존의 "abc"에 "def"를 추가 : abcdef
		System.out.println("strBuilder : "+strBuilder); // abcdef
		strBuilder.insert(3, "AAA"); // 3번째에 "AAA" 추가   abcAAAdef
		System.out.println("strBuilder : "+strBuilder);
		strBuilder.delete(3, 5); // 3번째부터 5번째 앞까지 삭제 : abcAdef
		System.out.println("StrBuilder : "+strBuilder);
		strBuilder.deleteCharAt(3); // 3번째 문자만 삭제 delete(3,4)
		System.out.println("strBuilder : "+strBuilder);
		System.out.println("해쉬코드 결과 : "+strBuilder.hashCode());
	}
}
