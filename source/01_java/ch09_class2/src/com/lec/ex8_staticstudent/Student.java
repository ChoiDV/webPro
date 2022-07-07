package com.lec.ex8_staticstudent;

public class Student {
	private static int count = 0;
	private int no;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	// Student s = new Student("沥快己",90,90,90);
	public Student() {} // 叼弃飘 积己磊
	public Student(String name, int kor, int eng, int mat) {
		no = ++count;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = tot / 3.0;
	}
	// s.print() -> 沥快己 90 90 90 270 90.0 sysout
	public void print() {
		System.out.printf("%d \t %s \t %d \t %d \t %d \t %d \t %.1f\n", 
				no, name, kor, eng, mat, tot, avg);
	}
	// System.out.println(s.infoString());
	public String infoString() {
		return String.format("%d \t %s \t %d \t %d \t %d \t %d \t %.1f", 
				no, name, kor, eng, mat, tot, avg);
	}
	public String getName() {return name;}
	public int getKor() {return kor;}
	public int getEng() {return eng;}
	public int getMat() {return mat;}
	public int getTot() {return tot;}
	public double getAvg() {return avg;}
}
