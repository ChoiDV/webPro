package com.lec.ex2_parking;
import java.util.Scanner;

import com.lec.cons.Constant;
public class Parking {
	private String no;
	private int inTime;
	private int outTime;
	private int fee;
//	private final int HOURLYPARKINGRATE=2000;
	public Parking() {}
	public Parking(String no, int inTime) {
		this.no = no;
		this.inTime = inTime;
		inPrint();
	}
	private void inPrint() {
		System.out.println("\""+no+"\"님 어서오세요");
		System.out.println("입차시간 : "+ inTime +"시");
		System.out.println("***********************");
	}//car1.out(15)
	public void out(int outTime) {
		this.outTime = outTime;
		fee = (outTime-inTime) * Constant.HOURLYPARKINGRATE;
		System.out.println("\""+no+"\"님 안녕히 가세요");
		System.out.println("입차시간 : "+ inTime +"시");
		System.out.println("출차시간 : "+ outTime +"시");
		System.out.println("주차요금 : "+fee+"원");
		System.out.println("***********************");
	}
	public void out() {
		Scanner scanner = new Scanner(System.in);
		System.out.print(inTime+"시에 들어오셨는데 몇시에 출차하시나요? ");
		outTime = scanner.nextInt();
		out(outTime);
		scanner.close();
	}
}














