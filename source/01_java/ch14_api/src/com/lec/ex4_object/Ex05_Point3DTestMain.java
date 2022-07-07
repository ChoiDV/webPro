package com.lec.ex4_object;

public class Ex05_Point3DTestMain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Point3D a = new Point3D();
		Point3D b = new Point3D(5.5, 4.4, 3.3);
		Point3D c = (Point3D) b.clone();
		if (b!=c && b.equals(c)) {
			System.out.println("복제 성공");
		}else {
			System.out.println("복제 실패");
		}
		System.out.println("a"+a);
		System.out.println("b"+b);
		System.out.println("c"+c);
	}
}
