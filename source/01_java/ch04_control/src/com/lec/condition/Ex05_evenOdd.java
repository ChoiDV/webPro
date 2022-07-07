package com.lec.condition;

public class Ex05_evenOdd {
	public static void main(String[] args) {
		int num = -3;
		// if
		if(num%2 == 0) {
			System.out.print("Â¦¼ö");
		}else {
			System.out.print("È¦¼ö");
		}
		// switch
		switch(num%2) {
			case 0 : System.out.print("Â¦¼ö"); break;
			default : System.out.print("È¦¼ö"); break;
		}
		// »ïÇ×¿¬»êÀÚ
		System.out.print(num%2==0 ? "Â¦¼ö":"È¦¼ö");
	}
}










