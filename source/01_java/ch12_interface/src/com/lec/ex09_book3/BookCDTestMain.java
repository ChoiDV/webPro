package com.lec.ex09_book3;
import java.util.Scanner;
public class BookCDTestMain {
	public static void main(String[] args) {
		BookLib[] books = {new BookLib("b01","java","홍길동"), 
						   new BookLib("b02","dbms","신길동"),
						   new BookLib("b03","web", "유길동"),
						   new BookLib("b04","jsp", "고길동"),
						   new BookLib("b11","spring", "김길동")};
		CDLib[] cds = {new CDLib("c01", "java_cd", "b01"),
					   new CDLib("c02", "ITtrend", null),
					   new CDLib("c03", "jsp", "b04") };
		Scanner scanner = new Scanner(System.in);
		int fn; // 기능번호
		int idx; // 대출하거나 반납하려고 할 때 조회된 책의 index
		String bTitle, borrower, checkoutDate; // 사용자에게 받을 책이름, 대출인, 대출일
		do {
			System.out.print("1:책대출 | 2:CD대출 | 3:책반납 | 4:CD반납 | 5:정보출력 | 0:종료");
			fn = scanner.nextInt();
			switch (fn) {
			case 1:
				//대출 : 1.책이름입력  2.책조회 3.책상태확인  4.대출인입력 5.대출일입력 6.대출메소드 7.CD여부확인
				// 1.책이름입력
				System.out.print("대출하고자 하는 책이름은 ?");
				bTitle = scanner.next(); // white-space 앞까지의 스트링만 받음
				// 2.책조회
				for(idx=0 ; idx<books.length ; idx++) {
					if( bTitle.equals(books[idx].getBookTitle()) ){
						break;
					}
				}// 책 조회 for
				if (idx==books.length) {
					System.out.println("현재 보유하지 않은 도서입니다.");
				}else { // books[idx] 도서를 대출 처리
					// 3.책상태확인
					if(books[idx].getState() == BookLib.STATE_BORROWED) { // 대출불가 상태
						System.out.println("현재 대출중인 도서입니다");
					}else { // 대출가능상태
						//4.대출인입력 5.대출일입력 6.대출메소드 호출
						System.out.print("대출자는 ?");
						borrower = scanner.next();
						System.out.print("대출일은 ?");
						checkoutDate = scanner.next();
						books[idx].checkOut(borrower, checkoutDate);
						// 7.CD여부확인
						int cdIdx;
						for(cdIdx=0 ; cdIdx<cds.length ; cdIdx++) {
							if(books[idx].getBookNo().equals(cds[cdIdx].getBookNo())) {
								break;
							}
						}// 딸린 CD가 있는지 조회
						if(cdIdx != cds.length) {
							System.out.print("딸린 CD가 있습니다. 대출하시겠습니까(y/n)?");
							String answer = scanner.next(); // y를 입력할 경우 CD 대출 진행
							if(answer.equals("y")) {
								cds[cdIdx].checkOut(borrower, checkoutDate);
							} // if - y를 입력할 경우 cd 대출도 진행
						}// if - cd가 있을 경우 
					} // if else - 도서 대출
				}
				break;
			case 2 : // CD 대출
				System.out.print("대출하고자 하는 CD 이름은 ?");
				bTitle = scanner.next();
				// bTitle이 배열에 있는지 검색하여 idx 추출
				for (idx = 0; idx < cds.length; idx++) {
					if (bTitle.equals(cds[idx].getCdTitle())) {
						break; // CD이름을 찾았으면 for문을 빠져나가
					} // if
				} // for-idx추출
				if (idx == cds.length) { // 대출할 책이 배열에 없는 경우
					System.out.println("원하는 CD가 없습니다");
				} else if (idx < cds.length) {// 대출할 책이 배열 idx 인덱스에 있는 경우
					if(cds[idx].getState() == CDLib.STATE_BORROWED) { // 대출불가 상태
						System.out.println("현재 대출중인 CD입니다");
					}else {
						// cd 대출하기
						System.out.print("대출인은 ? ");
						borrower = scanner.next();
						System.out.print("대출일은 ? ");
						checkoutDate = scanner.next();
						cds[idx].checkOut(borrower, checkoutDate);
					}
				} // if
				break;
			case 3: // 반납 : 1.책이름  2.책조회  3.반납 
				// 1.책이름
				System.out.print("반납할 책이름은 ?");
				bTitle = scanner.next();
				// 2.책조회
				for(idx=0 ; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if(idx == books.length) {
					System.out.println("해당 도서는 본 도서관의 책이 아닙니다");
				}else {// idx가 찾은 그 위치
					// 3.반납 
					books[idx].checkIn();
				}
				break;
			case 4 : // CD 반납 : 1.CD이름  2.CD조회  3.반납 
				// 1.CD이름
				System.out.print("반납할 CD 이름은 ?");
				bTitle = scanner.next();
				// 2. CD조회
				for(idx=0 ; idx<cds.length ; idx++) {
					if(bTitle.equals(cds[idx].getCdTitle())) {
						break;
					}
				}
				if(idx == cds.length) {
					System.out.println("해당 CD가 없습니다");
				}else {// idx가 찾은 그 위치
					// 3.반납 
					cds[idx].checkIn();
				}
				break;
			case 5:
				for(BookLib book : books) {
					book.printState();
				}
				for(CDLib cd : cds) {
					cd.printState();
				}
				break;
			}
		}while(fn!=0);
		System.out.println("BYE");
		scanner.close();
	}// main
}// class












