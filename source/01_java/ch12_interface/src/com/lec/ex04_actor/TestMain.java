package com.lec.ex04_actor;
public class TestMain {
	public static void main(String[] args) {
		Actor park = new Actor("박보검");
		park.canCatchCriminal();
		park.canSearch();
		park.outFire();
		park.saveMan();
		park.makePizza();
		park.makeSpaghetti();
		IChef chefPark = new Actor("박요리사");
//		chefPark.canCatchCriminal(); 불가
		chefPark.makePizza();
		chefPark.makeSpaghetti();
		IFireFighter firePark = new Actor("박");
//		firePark.makePizza(); 불가
		firePark.outFire();
		firePark.saveMan();
		IPoliceMan policePark = new Actor("박");
//		policePark.outFire(); 불가
		policePark.canCatchCriminal();
		policePark.canSearch();
	}
}












