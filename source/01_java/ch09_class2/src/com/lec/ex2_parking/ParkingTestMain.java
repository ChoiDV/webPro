package com.lec.ex2_parking;
public class ParkingTestMain {
	public static void main(String[] args) {
		Parking car1 = new Parking("111루1111", 12);
		Parking car2 = new Parking("22루2222", 12);
		car1.out();	// 사용자에게 outTime 받기								
		car2.out(15); // outTime은 15로 받기
	}
}
