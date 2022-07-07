package com.lec.ex8_staticstudent;
public class StaticStudentTestMain {
	public static void main(String[] args) {
		Student[] students = {new Student("정우성", 90, 91, 91),
				  new Student("김하늘", 100, 80, 95),
				  new Student("황정민", 95, 80, 90),
				  new Student("강동원", 95, 90, 99),
				  new Student("유아인", 90, 90, 80)};
		int[] tot = new int[5]; // 점수 누적(국,영,수,총점,평균)
		int[] avg = new int[5]; // 평균(정수로)
		printLine('■');
		System.out.println("\t\t\t성 적 표");
		printLine('-');
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		printLine('-');
		for (Student student : students) {
			System.out.println(student.infoString());
			tot[0] += student.getKor();
			tot[1] += student.getEng();
			tot[2] += student.getMat();
			tot[3] += student.getTot();
			tot[4] += student.getAvg();
		}
		for(int idx=0 ; idx<avg.length ; idx++) {
			avg[idx] = tot[idx]/students.length; // 버림
			avg[idx] = (int)(tot[idx]/(double)students.length+0.5); // 반올림
			avg[idx] = (int)Math.round(tot[idx]/(double)students.length );
		}
		printLine('-');
		System.out.print("총점"+"\t\t");
		for(int t : tot) {
//			System.out.print(t+"\t");
			System.out.printf("%4d\t",t);
		}
		System.out.println();
		System.out.print("평균"+"\t\t");
		for(int a : avg) {
//			System.out.print(a+"\t");
			System.out.printf("%4d\t",a);
		}
		System.out.println();
		printLine('■');
	}
	private static void printLine(char ch) {
		for(int i=0 ; i<60 ; i++) { // 한줄에 cnt번 ch를 출력
			System.out.print(ch);
		}
		System.out.println(); // 개행
	}
}
