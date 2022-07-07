package com.lec.ex;
// 1~10까지 정수의 합을 출력하고 그 합이 짝수인지 홀수인지 출력
public class Ex02 {
	public static void main(String[] args) {
		int tot = sum(10);
		System.out.println("1~10까지 누적합은 "+tot);
		System.out.println( evenOdd(tot) );		
		tot = sum(10, 100);
		System.out.println("10~100까지 누적합은 "+tot);
		System.out.println( evenOdd(tot) );
	}
	private static int sum(int to) { // 함수의 오버로딩
		int result = 0;
		for(int i=1 ; i<=to ; i++) {
			result += i; //result = result + i; 
		}
		return result;
	}
	private static int sum(int from, int to) { // from ~ to까지 누적한 결과 return
		int result = 0;
		for(int i=from ; i<=to ; i++) {
			result += i; //result = result + i; 
		}
		return result;
	}
	private static String evenOdd(int value) {
		return value%2==0 ? "짝수입니다" : "홀수입니다";
//		String result = null;
//		if(value%2 == 0) {
//			result = "짝수입니다";
//		}else {
//			result = "홀수입니다";
//		}
		//return result;
	}
	
	
}





















