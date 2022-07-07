package com.lec.ex1_store;
// HeadQuarterStore hstore = new HeadQuarterStore("본사"); 객체 생성 불가
public abstract class HeadQuarterStore {
	private String str; // "본사"
	public HeadQuarterStore(String str) {this.str = str;}
	// 메소드 구현은 없고 선언만 되어 있는 메소드 : 추상 메소드 (상속받은 클래스에서 오버라이드)
	// 클래스 내 추상 메소드가 하나 이상일 때 : 추상클래스
	public abstract void kimchi();
	public abstract void bude();
	public abstract void bibib();
	public abstract void sunde();
	public abstract void gonggibab() ;
	public String getStr() {return str;}
	public void setStr(String str) {this.str = str;}
}
