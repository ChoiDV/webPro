package com.lec.loop;
// break : 블럭을 완전히 빠져 나감
// continue : 블럭의 실행을 멈추고 증감부분으로 감
public class Ex05breakContinue {
	public static void main(String[] args) {
		for(int i=0; i<=5 ; i++ ) {
			if(i==3) {
				//break; 
				continue;
			}
			System.out.println(i+". 안녕");
		}
	}
}
