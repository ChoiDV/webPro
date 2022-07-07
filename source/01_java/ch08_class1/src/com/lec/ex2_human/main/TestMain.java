package com.lec.ex2_human.main;
// com.lec.ex2_human 패키지의 모든 class를 import -> 불필요한 package import 삭제:ctrl+shift+o
import com.lec.ex2_human.*;
public class TestMain {
	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		if(i==j) { // 기초데이터 타입에서의 같은지 비교
			System.out.println("i와 j는 같다");
		}
		String name = "홍길동";
		String name2 = "홍길동";
		if(name.equals(name2)) { // 객체변수가 같은지 비교시
			System.out.println("name과 name2는 같다");
		}
		Woman hee1 = new Woman();
		Woman hee2 = new Woman();
		// hee1.method();
		if(hee1.equals(hee2)) {
			System.out.println("hee1과 hee2는 같다");
		}
		Man kang = new Man(22,165,60.2);
		Man kim  = new Man(22,180, 65.6);
		Man kim1; // 레퍼런스 변수(객체변수) 선언
		kim1 = kim;
		Man kim2 = new Man(22, 180, 65.6);
		if(kim.equals(kim1)) {
			System.out.println("kim과 kim1은 같다(같은 주소를 가리킨다)");
		}
		if(!kim.equals(kim2)) {
			System.out.println("kim과 kim2는 다른 객체다(다른 주소값이 있다)");
		}
		kang.setHeight(160);
		kang.setWeight(51); // 51은 묵시적인  형변환(double형으로)
		if(kang.calculateBMI() > 30) {
			System.out.println("건강하세요");
		}else {
			System.out.println("건강하겠네요");
		}
		
	}
}
























