package com.lec.condition;

import java.util.Scanner;

// 0 <= Math.random() <1
// 0 <= Math.random()*3 < 3
// (int)(Math.random()*3) : 0,1,2 중의 하나
public class Quiz5_if_srpGame2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int you, computer = (int) (Math.random() * 3); // 0,1,2
		System.out.print("가위(0), 바위(1), 보(2) 중 하나 선택 :");
		you = sc.nextInt(); // 정수를 입력 받음
		if (you == 0) {
			System.out.print("당신은 가위\t");
		} else if (you == 1) {
			System.out.print("당신은 바위\t");
		} else if (you == 2) {
			System.out.print("당신은 보자기\t");
		} else {
			System.out.print("당신은 잘못 냈어요. 바이");
			you = 3; // 끝내기 위한 조건
		} // if - you출력
		if (you != 3) { // 컴퓨터가 낸 것과 승패 출력
			String msg = (computer == 0) ? "컴이 가위" : (computer == 1) ? "컴이 바위" : "컴이 보자기";
			System.out.println(msg);
			// 경우의 수가 3가지 : 졌다, 이겼다, 비겼다
			if( (you+1)%3 == computer) {
				System.out.println("당신이 졌어요 ");
			}else if(you == computer ) {
				System.out.println("비겼다");
			}else {
				System.out.println("당신이 이겼어요 ");
			}// if - 승패 출력
		} // if
	}// main
}// class










