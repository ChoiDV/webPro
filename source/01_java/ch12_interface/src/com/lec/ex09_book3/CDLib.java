package com.lec.ex09_book3;
// CDLib c = new CDLib("c01","java_cd", "890ㅁ-101-1ㄱ");
public class CDLib extends CDInfo implements ILendable {
	private String borrower;
	private String checkOutDate;
	private byte state;
	public CDLib(String cdNo, String cdTitle, String bookNo) {
		super(cdNo, cdTitle, bookNo);
	}
	@Override
	public void checkOut(String borrower, String checkoutDate) {
		if(state == STATE_BORROWED) { // 대출중이면 메세지 뿌리고 끝
			System.out.println(getCdTitle() +" CD는 대출중입니다");
			return;
		}
		// state가 0이라 대출처리 진행
		this.borrower = borrower;
		this.checkOutDate = checkoutDate;
		state = STATE_BORROWED; // 대출중 상태로 전환
		System.out.println(getCdTitle() + " CD가 대출 처리되었습니다");
		System.out.println("대출인 : "+borrower +"\t대출일 : "+checkoutDate);
	}
	// c.checkIn() 반납 : state 확인해서 대출가능(0)이면 메세지 뿌리고 중단, 대출중(1)이면 반납진행
	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
			System.out.println(getCdTitle() + "CD는 반납완료된 CD인데 이상합니다. 예외다");
			return;
		}
		// state가 대출중(1)이라 반납 진행
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getCdTitle() +" CD가 반납 완료되었습니다");
	}
	// c.printState() => 101 javaSrc 딸린책:b01 대출중
	@Override
	public void printState() {
		String msg = getCdNo() + "\t"; 
		msg += getCdTitle() + "\t";
		msg += (getBookNo()==null)? "단독CD\t\t": "딸린책:"+getBookNo() +"\t";
		msg += ( (state==STATE_NORMAL)? "대출가능" : (state==STATE_BORROWED)? "대출중":"이상해" );
		System.out.println(msg);
	}
	public byte getState() {return state;}
}










