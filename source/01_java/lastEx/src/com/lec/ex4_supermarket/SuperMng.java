package com.lec.ex4_supermarket;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class SuperMng extends JFrame implements ActionListener{
	// DAO
	private CustomerDao dao = CustomerDao.getInstance();
	// 화면구현
	private Container container;
	private JPanel    jpup, jpbtn;
	private JTextField txtCid, txtCtel, txtCname, txtCpoint, txtCamount;
	private Vector<String> levelNames;
	private JComboBox<String> comLevelName;
	private JButton btnCidSearch, btnCtelSearch, btnCnameSearch, btnBuyWithPoint;
	private JButton btnBuy, btnLevelNameOuput, btnAllOutput, btnInsert,
					btnCtelUpdate, btnDelete, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	public SuperMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 컴포넌트 객체 생성
		container = getContentPane(); // 컨테이너는 기본이 BorderLayout
		container.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(6, 3));  // 패널은 기본이 FlowLayout
		jpbtn = new JPanel();
		txtCid     = new JTextField(20);
		txtCtel    = new JTextField(20);
		txtCname   = new JTextField(20);
		txtCpoint     = new JTextField(20);
		txtCamount    = new JTextField(20);
		levelNames    = dao.getLevelNames();
		comLevelName  = new JComboBox<String>(levelNames);
		btnCidSearch    = new JButton("아이디검색");
		btnCtelSearch   = new JButton("폰4자리(FULL)검색");
		btnCnameSearch  = new JButton("고객이름검색");
		btnBuyWithPoint = new JButton("포인트로만구매");
		btnBuy          = new JButton("물품구입");
		btnLevelNameOuput = new JButton("등급별출력");
		btnAllOutput    = new JButton("전체출력");
		btnInsert       = new JButton("회원가입");
		btnCtelUpdate   = new JButton("번호수정");
		btnDelete       = new JButton("회원탈퇴");
		btnExit         = new JButton("나가기");
		txtPool  = new JTextArea(6, 70);
		scrollPane = new JScrollPane(txtPool);
		// 컨테이너에 컴포넌트 배치
		jpup.add(new JLabel("아  이  디", (int)CENTER_ALIGNMENT));
		jpup.add(txtCid);
		jpup.add(btnCidSearch);
		jpup.add(new JLabel("고객전화", (int)CENTER_ALIGNMENT));
		jpup.add(txtCtel);
		jpup.add(btnCtelSearch);
		jpup.add(new JLabel("고객이름", (int)CENTER_ALIGNMENT));
		jpup.add(txtCname);
		jpup.add(btnCnameSearch);
		jpup.add(new JLabel("포  인  트", (int)CENTER_ALIGNMENT));
		jpup.add(txtCpoint);
		jpup.add(btnBuyWithPoint);
		jpup.add(new JLabel("구매금액", (int)CENTER_ALIGNMENT));
		jpup.add(txtCamount);
		jpup.add(new JLabel()); // 5행 3열엔 빈 라벨 추가
		jpup.add(new JLabel("고객등급", (int)CENTER_ALIGNMENT));
		jpup.add(comLevelName);
		jpbtn.add(btnBuy);
		jpbtn.add(btnLevelNameOuput);
		jpbtn.add(btnAllOutput);
		jpbtn.add(btnInsert);
		jpbtn.add(btnCtelUpdate);
		jpbtn.add(btnDelete);
		jpbtn.add(btnExit);
		container.add(jpup);
		container.add(jpbtn);
		container.add(scrollPane);
		setVisible(true);
		setSize(new Dimension(800,400));
		setLocation(200, 100);
		txtPool.setText("\t★★★ 고객 검색 후 구매하세요");
		
		// 이벤트 추가
		btnCidSearch.addActionListener(this);
		btnCtelSearch.addActionListener(this);
		btnCnameSearch.addActionListener(this);
		btnBuyWithPoint.addActionListener(this);
		btnBuy.addActionListener(this);
		btnLevelNameOuput.addActionListener(this);
		btnAllOutput.addActionListener(this);
		btnInsert.addActionListener(this);
		btnCtelUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCidSearch) { // 아이디 검색
			// cid 입력란 외에는 기본으로 비워놓고 로직 수행
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");
			int cid;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
			} catch (Exception e2) {
				txtPool.setText("유효한 고객 ID를 입력하신후 검색하세요");
				return;
			}//try-catch
			CustomerDto customer = dao.cIdGetCustomer(cid);
			if(customer!=null) {
				// txtCid.setText(String.valueOf(customer.getCid()));
				txtCtel.setText(customer.getCtel());
				txtCname.setText(customer.getCname());
				txtCpoint.setText(String.valueOf(customer.getCpoint()));
				txtCamount.setText(""); // 물품구매액 넣을 예정
				comLevelName.setSelectedItem(customer.getLevelName());
				txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을위한추가구매액\n");
				txtPool.append("───────────────────────────────────────────────────────────\n");
				txtPool.append(customer.toString());
			}else {
				txtPool.setText("검색되지 않은 ID입니다");
			}
		}else if(e.getSource()==btnCtelSearch) { // 폰4자리 검색
			// ctel 입력란 외에는 기본으로 비워놓고 로직 수행
			txtCid.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");
			String ctel = txtCtel.getText().trim();
			if(ctel.length()<4) {
				txtPool.setText("적어도 폰4자리 이상은 입력하여야 검색됩니다");
				return;
			} // if
			ArrayList<CustomerDto> customers = dao.cTelGetCustomer(ctel);
			if(customers.size()!=0) { // 출력
				txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을위한추가구매액\n");
				txtPool.append("───────────────────────────────────────────────────────────\n");
				for(CustomerDto customer : customers) {
					txtCid.setText(String.valueOf(customer.getCid()));
					txtCname.setText(customer.getCname());
					txtCtel.setText(customer.getCtel());
					txtCpoint.setText(String.valueOf(customer.getCpoint()));
					txtCamount.setText(""); // 물품구매할 금액이 넣어질 예정인 textField
					comLevelName.setSelectedItem(customer.getLevelName());
					txtPool.append(customer.toString() + "\n");
				}
			}else {
				txtPool.setText("해당 전화번호의 고객이 검색되지 않습니다. 회원가입 해주세요");
			}
		}else if(e.getSource()==btnCnameSearch) { // 이름 검색
			// cname 입력란 외에는 기본으로 비워놓고 로직 수행
			txtCid.setText("");
			txtCtel.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");
			String cname = txtCname.getText().trim();
			if(cname.length()<2) {
				txtPool.setText("적어도 이름은 2글자 이상은 입력하여야 검색됩니다");
				return;
			} // if
			ArrayList<CustomerDto> customers = dao.cNameGetCustomer(cname);
			if(customers.size()!=0) { // 출력
				txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을위한추가구매액\n");
				txtPool.append("───────────────────────────────────────────────────────────\n");
				for(CustomerDto customer : customers) {
					txtCid.setText(String.valueOf(customer.getCid()));
					txtCname.setText(customer.getCname());
					txtCtel.setText(customer.getCtel());
					txtCpoint.setText(String.valueOf(customer.getCpoint()));
					txtCamount.setText(""); // 물품구매할 금액이 넣어질 예정인 textField
					comLevelName.setSelectedItem(customer.getLevelName());
					txtPool.append(customer.toString() + "\n");
				}
			}else {
				txtPool.setText("해당 이름의 고객이 검색되지 않습니다. 회원가입 해주세요");
			}
		}else if(e.getSource()==btnBuyWithPoint) { // 포인트구매
			int cid, cpoint, camount;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
				cpoint = Integer.parseInt(txtCpoint.getText().trim());
				camount = Integer.parseInt(txtCamount.getText().trim());
				if(cpoint < camount) {
					txtPool.setText("포인트가 부족하여 포인트 구매가 불가합니다");
					return;
				}
			}catch (Exception e1) {
				txtPool.setText("유효한 고객ID와 point와 구매금액을 입력하신후 구매하세요");
				return;
			}
			int result = dao.buyWithPoint(cid, camount);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("포인트 구매성공");
				txtCpoint.setText(String.valueOf(cpoint-camount)); // 차감된 포인트로 수정
				txtCamount.setText("");
			}else {
				txtPool.setText("고객 아이디가 유효하지 않습니다. 고객 검색 후 구매해 주세요");
			}
		}else if(e.getSource()==btnBuy) { // 물품구매
			int cid, cpoint, camount;
			try {
				cid     = Integer.parseInt(txtCid.getText().trim());
				cpoint  = Integer.parseInt(txtCpoint.getText().trim());
				camount = Integer.parseInt(txtCamount.getText().trim());
			} catch (NumberFormatException e2) {
				txtPool.setText("유효한 고객ID로 검색후, 구매금액을 입력하시고 구매하세요");
				return;
			}
			int result = dao.buy(cid, camount);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("물품 구매 완료");
				txtCpoint.setText(String.valueOf(cpoint + (int)(camount*0.05)));
				txtCamount.setText("");
			}else {
				txtPool.setText("고객 아이디가 유효하지 않습니다. 고객 검색후 구매하세요");
			}			
		}else if(e.getSource()==btnLevelNameOuput) { // 등급별 출력
			// levelName 입력 콤보박스 외에는 기본으로 비워놓고 로직 수행
			txtCid.setText("");
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			// comLevelName.setSelectedItem("");
			String levelName = comLevelName.getSelectedItem().toString();
			if(levelName.length()==0) {
				txtPool.setText("원하는 등급을 선택하시고 검색하세요");
				return;
			} // if
			ArrayList<CustomerDto> customers = dao.levelNameGetCustomer(levelName);
			if(customers.size()!=0) { // 출력
				txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을위한추가구매액\n");
				txtPool.append("───────────────────────────────────────────────────────────\n");
				for(CustomerDto customer : customers) {
					txtPool.append(customer.toString() + "\n");
				}
				txtPool.append("총 " + customers.size() + "명");
			}else {
				txtPool.setText("해당 레벨의 고객이 검색되지 않습니다. 회원가입 해주세요");
			}
		}else if(e.getSource()==btnAllOutput) {//전체출력
			// 모든 입력 콤퍼넌트를 비워놓고 로직 수행
			txtCid.setText("");
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");
			ArrayList<CustomerDto> customers = dao.getCustomers();
			if(customers.size()!=0) { // 출력
				txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을위한추가구매액\n");
				txtPool.append("───────────────────────────────────────────────────────────\n");
				for(CustomerDto customer : customers) {
					txtPool.append(customer.toString() + "\n");
				}
				txtPool.append("총 " + customers.size() + "명");
			}else {
				txtPool.setText("등록된 고객이 검색되지 않습니다.");
			}	
		}else if(e.getSource()==btnInsert) {//회원가입
			// ctel, cname 입력란을 제외하고 빈스트링 및 초기값으로 정리
			txtCid.setText("");
			txtCpoint.setText("1000");
			txtCamount.setText("");
			comLevelName.setSelectedItem("NORMAL");
			String ctel = txtCtel.getText().trim();
			String cname = txtCname.getText().trim();
			if(ctel.length()<8|| cname.length()<2) {
				txtPool.setText("전화번호와 이름을 확인해 주세요(전화번호는 8자리 이상, 이름은 2글자이상)");
				return;
			}
			int result = dao.insertCustomer(ctel, cname);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("회원가입 감사합니다. 포인트 1000점을 가입선물로 드립니다");
			}					
		}else if(e.getSource()==btnCtelUpdate) {//번호수정
			int cid; String ctel;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
				ctel = txtCtel.getText().trim();
				if(ctel.length()<8) {
					txtPool.setText("변경할 전화번호를 확인해 주세요");
					return;
				}
			} catch (Exception e2) {
				txtPool.setText("유효한 고객 ID로 검색후 수정하세요");
				return;
			}
			int result = dao.updateCustomer(cid, ctel);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("전화번호가 수정되었습니다");
			}else {
				txtPool.setText("유효한 고객 ID로 검색후 수정하세요");
			}
		}else if(e.getSource()==btnDelete) { // 회원탈퇴
			// ctel 입력란 외에는 기본으로 비워놓고 로직 수행
			txtCid.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");
			String ctel = txtCtel.getText().trim();
			if(ctel.equals("")) {
				txtPool.setText("전화번호를 입력 후 회원탈퇴해 주세요");
				return;
			}
			int result = dao.deleteCustomer(ctel);
			if(result==CustomerDao.SUCCESS) {
				txtPool.setText("회원탈퇴 완료");
				txtCtel.setText("");
			}else {
				txtPool.setText("등록된 전화번호가 아니여서 회원탈퇴 진행 불가합니다");
			}
		}else if(e.getSource()==btnExit) {// 나가기
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new SuperMng("슈퍼마켓 관리");
	}
}













