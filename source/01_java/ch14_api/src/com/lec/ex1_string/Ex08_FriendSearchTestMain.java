package com.lec.ex1_string;

import java.util.Scanner;

public class Ex08_FriendSearchTestMain {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("홍길동", "010-9999-9999", "05-22"),
				new Friend("신길동", "010-8888-8888", "03-28"),
				new Friend("마길동", "010-8888-9999", "08-22"),
				new Friend("윤길동", "010-7777-7777", "04-22"),
				new Friend("김길동", "010-6666-7777", "03-22")};
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("검색하고자 하는 친구의 전화번호 뒷자리는 ?");
			String searchTel = sc.next() ; // 사용자로부터 전화번호 뒷번호 입력 받은 데이터 할당
			if(searchTel.equals("x")) break;
			boolean searchOk = false;
			for(int idx=0 ; idx<friends.length ; idx++) {
				// idx번째의 Friend객체 전화번호 뒷자리 추출
				String tel = friends[idx].getPhone();
				String post = tel.substring(tel.lastIndexOf('-')+1);
//				String post = friends[idx].getPhone().substring(friends[idx].getPhone().lastIndexOf('-')+1);
				if(post.equals(searchTel)) {
					System.out.println(friends[idx]);
					searchOk = true;
				}// if - 전화번호를 찾을 경우 더이상 검색하지 않고 for문 빠져나감.
			}//for
			if(! searchOk) {
				System.out.println("검색하신 친구는 조회되지 않습니다.");
			}// if
		}//while
		sc.close();
	}//main
}//class
