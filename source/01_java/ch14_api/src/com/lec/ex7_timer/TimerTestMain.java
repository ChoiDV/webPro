package com.lec.ex7_timer;
import java.util.Timer;
import java.util.TimerTask;
public class TimerTestMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("시작");
		Timer timer = new Timer(true); // 프로그램이 끝나도 계속 timer상주
		TimerTask task1 = new TimerTaskEx1();
		TimerTask task2 = new TimerTaskEx2();
		timer.schedule(task1, 2000); // 2초후에 task1.run() 수행
		timer.schedule(task2, 1000, 500); // 1초후 0.5초마다 task2.run() 수행
		// 5초동안 잠깐 멈춤 
		Thread.sleep(5000);
		System.out.println("끝");
	}
}
