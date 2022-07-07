package com.lec.ex4_object;
// new Point3D(1, 1, 2)
public class Point3D implements Cloneable{
	private double x;
	private double y;
	private double z;
	public Point3D(){ }
	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Point3D){
			boolean xBool = (x == ((Point3D)obj).x);
			boolean yBool = (y == ((Point3D)obj).y);
			boolean zBool = (z == ((Point3D)obj).z);
			return xBool && yBool && zBool;
		}
		return false;
	}
	@Override
	public String toString() {
		return "ÁÂÇ¥°ª ["+x+", "+y+", "+z+"]";
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
