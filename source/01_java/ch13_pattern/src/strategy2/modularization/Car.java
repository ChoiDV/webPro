package strategy2.modularization;
// 3가지 부품 변수 / 생성자X / drive(일반), shape(추상), engine(일반), km(일반), fuel(일반), setter 
import strategy2.interfaces.*;
public abstract class Car {
	private IEngine engine;// 3가지 부품 변수
	private IKm     km;
	private IFuel   fuel;
	public void drive() {
		System.out.println("드라이브 할 수 있습니다");
	}
	public abstract void shape();
	public void engine() {
		engine.engine();
	}
	public void km() {
		km.km();
	}
	public void fuel() {
		fuel.fuel();
	}
	public void setEngine(IEngine engine) {this.engine = engine;}
	public void setKm(IKm km) {this.km = km;}
	public void setFuel(IFuel fuel) {this.fuel = fuel;}
}
