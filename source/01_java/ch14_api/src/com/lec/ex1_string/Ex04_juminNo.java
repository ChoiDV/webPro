package com.lec.ex1_string;
import java.util.Scanner;
// 예제. 주민번호를 입력받아 여자인지 남자인지 출력 예제. 주민번호는 “920225-2012121”형식으로 입력받는다.
public class Ex04_juminNo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("주민번호 ?");
		String juminNo = scanner.next(); // 001212-4123456
		// 방법1. charAt()함수 이용
//		char gender = juminNo.charAt(7);
//		if(gender=='1' || gender=='3') {
//			System.out.println("당신은 남자입니다");
//		}else if(gender=='2' || gender=='4') {
//			System.out.println("당신은 여자입니다");
//		}else {
//			System.out.println("어 이상하다");
//		}
		// 방법2. substring 결과를 숫자로 바꿔서 비료
//		int gender = Integer.parseInt(juminNo.substring(7, 8)); // "4"
//		String msg = (gender==1 || gender==3)? "남자":
//							(gender==2||gender==4)? "여자":"오류";
		// 방법3. 
		String gender = juminNo.substring(7,8);  // 001212-41212   "4"
		String msg = (gender.equals("1")||gender.equals("3")) ? "남자":
							(gender.equals("2") || gender.equals("4"))? "여자":"오류";
		System.out.printf("당신은 %s입니다",msg);
		scanner.close();
		
	}
}









