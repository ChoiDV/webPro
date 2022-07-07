package com.lec.ex14_account;
// CheckingAccount aa = new CheckingAccount("11-11","홍길동",2000,"1111-1111-2222-3333")
public class CheckingAccount extends Account {
	private String cardNo;
	public CheckingAccount(String accountNo, String ownerName, String cardNo) { // 잔액은 0
		super(accountNo, ownerName);
		this.cardNo = cardNo;
	}
	public CheckingAccount(String accountNo, String ownerName, long balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}
	// aa.pay("1111-1111-2222-3333",1000);
	public void pay(String cardNo, int amount) {
		if(cardNo.equals(this.cardNo)) { // 올바른 카드 번호인지 확인
			if(getBalance() >= amount) { // 지불가능한지(잔액이 지불할 금액 이상)
				setBalance( getBalance() - amount); //balance = balance - amount;
				System.out.printf("%s(%s)님 %d원 지불하여 잔액 %d원 남았습니다\n",
							getOwnerName(), getAccountNo(), amount, getBalance());
			}else {
				System.out.printf("%s(%s)님 잔액 %d원으로 %d원 지불 불가합니다\n",
								getOwnerName(), getAccountNo(), getBalance(), amount);
			} // if
		}else {
			System.out.println("올바른 카드번호를 입력하세요");
		} // if
	}// pay
	public String getCardNo() {
		return cardNo;
	}
} // class
















