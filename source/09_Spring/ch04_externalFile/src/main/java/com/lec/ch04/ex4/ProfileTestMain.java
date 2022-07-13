package com.lec.ch04.ex4;
import java.util.Scanner;
import org.springframework.context.support.GenericXmlApplicationContext;
public class ProfileTestMain {
	public static void main(String[] args) {
		String config = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("dev중? run중? ");
		String answer = sc.next();
		if(answer.equalsIgnoreCase("dev")) {
			config = "dev";
		}else if(answer.equalsIgnoreCase("run")) {
			config = "run";
		}else {
			System.out.println("제대로 된 환경이 입력되지 않았습니다.");
			System.exit(0);
		}
		sc.close();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load("classpath:META-INF/ex4/dev.xml", "classpath:META-INF/ex4/run.xml");
		ctx.refresh();
		EnvInfo envInfo = ctx.getBean("envInfo", EnvInfo.class);
		System.out.println("ipNum = " + envInfo.getIpNum());
		System.out.println("portNum = " + envInfo.getPortNum());
		System.out.println("userId = " + envInfo.getUserId());
		System.out.println("userPw = " + envInfo.getUserPw());
	}
}























