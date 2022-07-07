package com.lec.ex03_phone;
public class TestMain {
	public static void main(String[] args) {
		AModel a = new AModel();
		BModel b = new BModel();
		CModel c = new CModel();
		IAcorporation[] phone = {a, b, c};
		for(IAcorporation p : phone) {
			System.out.println(p.getClass().getName()); // Å¬·¡½º com..lec.ex03_phone.XModel
			p.dmbReceive();
			p.lte();
			p.tvRemoteControl();
		}
	}
}
