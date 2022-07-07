package com.lec.homework;

public class Ex {
	public static void main(String[] args) {
		int kor = 99;
		int mat = 100;
		int eng = 99;
		int sum = kor + mat + eng;
		double avg = sum/3.0;
		System.out.printf("국어는 %d점, 수학은 %d점, 영어는 %d점입니다.\n", 
														kor, mat, eng);
		System.out.printf("총점은 %d점. 평균은 %.1f", sum, avg);
	}
}
