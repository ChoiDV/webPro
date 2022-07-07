package strategy2.modularization;
import strategy2.interfaces.*;
//상속받은 멤버 : 3가지 부품 변수 /  drive(일반), shape(추상), engine(일반), km(일반), fuel(일반), setter
public class Genesis extends Car {
	public Genesis() {
		setEngine(new EngineHigh());//engine = new EngineHigh();
		setKm(new Km10());          //km = new Km10();
		setFuel(new FuelGasoline());//fuel = new FuelGasoline();
	}
	@Override
	public void shape() {
		System.out.println("제네시트 모양은 door, sheet, handle로 이루어져 있습니다.");
	}
}