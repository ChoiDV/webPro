package com.lec.ex09_book3;

public interface ILendable {
	public static final byte STATE_BORROWED =1;
	public final static byte STATE_NORMAL = 0;
	public void checkOut(String borrwer, String checkOutDate); // 대출하는 메소드
	public void checkIn();  // 반납하는 메소드
	public void printState(); // 도서나 ID의 정보와 대출 상태 출력
}
