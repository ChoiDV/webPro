package com.lec.ex1_string;
import java.util.Scanner;
// 전화번호 받아, 입력받은 전화번호, 짝수번째 문자, 꺼꾸로, 전화번호 앞자리, 전화번호 뒷자리
public class Ex06_telPrint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("전화번호를 입력하세요(010-9898-1234 형식)");
			String tel = sc.next(); // 스트링 입력
			if(tel.equalsIgnoreCase("x")) break;
			System.out.println("입력한 전화번호 : "+tel);
			System.out.print("짝수번째 문자열 : ");
			for(int i=0 ; i<tel.length() ; i++) {
				if(i%2 == 0) {
					System.out.print(tel.charAt(i)); // 짝수번째 문자 출력
				}else {
					System.out.print(' '); // 홀수번째 문자열 대신 ' ' 출력
				}
			}
			System.out.println(); // 개행
			System.out.print("문자를 꺼꾸로 :");
			for(int i=tel.length()-1 ; i>=0 ; i--) {
				System.out.print(tel.charAt(i));
			}
			System.out.println();
			int first = tel.indexOf('-');     // 첫 -가 나오는 위치 
			int last  = tel.lastIndexOf('-'); // 마지막 -가 나오는 위치
			String pre = tel.substring(0, first);   // 010-9898-9898   02-789-1234
			String post = tel.substring(last+1);
			String mid = tel.substring(first+1, last);
			System.out.println("전화번호 앞자리 : "+pre);
			System.out.println("전화번호 뒷자리 : "+post);
			System.out.println("전화번호 중간자리 : "+mid);
		}
	}
}

