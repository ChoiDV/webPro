package com.lec.loop;
// 1~40까지 한줄 4개씩 출력 1 2 3 4
public class Ex04_for {
	public static void main(String[] args) {
		for(int i=1 ; i<41 ; i++) {
			System.out.print(i+"\t");
			if(i%4 == 0) {
				System.out.println(); // i가 4의 배수이면 개행 추가
			}// if
		}//for
	}//main
}
