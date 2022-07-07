package com.lec.condition;
import java.util.Scanner;
//사용자로부터 국어, 영어, 수학 점수를 입력받아 각 과목별 점수가 평균 이상인지 미만인지 출력해 보자
public class Quiz3 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("국어점수를 입력 : ");
		int kor = scanner.nextInt();
		System.out.print("영어점수를 입력 : ");
		int eng = scanner.nextInt();
		System.out.print("수학점수를 입력 : ");
		int math = scanner.nextInt();
		double eve = (kor+eng+math)/3.0;
		if(kor>=eve){
			//System.out.println("국어점수가 평균점수("+eve+") 이상입니다");
			System.out.printf("국어점수가 평균점수(%3.1f)이상입니다\n", eve);
		} else if(kor<eve){
			//System.out.println("국어점수가 평균점수("+eve+") 이하입니다");
			System.out.printf("국어점수가 평균점수(%3.1f)이하입니다\n", eve);
		}
		if(eng>=eve){
			//System.out.println("영어점수가 평균점수("+eve+") 이상입니다");
			System.out.printf("영어점수가 평균점수(%3.1f)이상입니다\n", eve);
		}else {
			//System.out.println("영어점수가 평균점수("+eve+") 이하입니다");
			System.out.printf("영어점수가 평균점수(%3.1f)이하입니다\n", eve);
		}
		if(math>=eve){
			//System.out.println("수학점수가 평균점수("+eve+") 이상입니다");
			System.out.printf("수학점수가 평균점수(%3.1f)이상입니다\n", eve);
		}else {
			//System.out.println("수학점수가 평균점수("+eve+") 이하입니다");
			System.out.printf("수학점수가 평균점수(%3.1f)이하입니다\n", eve);
		}
		scanner.close();
	}
}
