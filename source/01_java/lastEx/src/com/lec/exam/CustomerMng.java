package com.lec.exam;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class CustomerMng extends JFrame implements ActionListener {
	private Container contenPane;
	private JPanel jpup, jpdown;
	private JTextField txtPhone, txtName, txtPoint;
	private JTextArea jta;
	private JScrollPane scrollbar;
	private JButton btnJoin, btnSearch, btnOutput, btnExit;
	private ArrayList<CustomerDto> customers;
	private CustomerDao dao = CustomerDao.getInstance();
	public CustomerMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 컨테이너 얻어오기
		contenPane = getContentPane();
		// 컨테이너 레이아웃 셋팅
		contenPane.setLayout(new FlowLayout());
		// 컴포넌트 생성
		jpup = new JPanel(new GridLayout(3, 2));
		jpdown = new JPanel();
				
		txtPhone = new JTextField(15);
		txtName = new JTextField(15);
		txtPoint = new JTextField("1000", 15);
		jta = new JTextArea(15,30);
		scrollbar = new JScrollPane(jta);
		btnJoin = new JButton("가입");
		btnSearch = new JButton("폰조회");
		btnOutput = new JButton("출력");
		btnExit = new JButton("종료");
		// jpup에 add
		jpup.add(new JLabel("폰번호",(int)CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel("이  름",(int)CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("포인트",(int)CENTER_ALIGNMENT));
		jpup.add(txtPoint);
		// jpdown에 add (버튼들 4)
		jpdown.add(btnJoin);
		jpdown.add(btnSearch);
		jpdown.add(btnOutput);
		jpdown.add(btnExit);
		// contenPane에 add
		contenPane.add(jpup);
		contenPane.add(jpdown);
		contenPane.add(scrollbar);
		setSize(new Dimension(400, 450));
		setLocation(2200, 100);
		setResizable(false);
		setVisible(true);
		// 이벤트 리스너 추가
		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnJoin) {	
			String phone, name; int point=1000;
			phone = txtPhone.getText().trim();
			name = txtName.getText().trim();
			try {
				point = Integer.parseInt(txtPhone.getText().trim());
			}catch (Exception e1) { }
			int preIdx = phone.indexOf("-");
			int postIdx = phone.lastIndexOf("-");
			if(phone.length()<11 || name.length()<2 ||
					preIdx==postIdx) { // 전화번호에 '-'가 없거나 하나일 경우
				jta.setText("유효한 값을 입력하세요");
				return;
			}
			//가입
			CustomerDto newCustomer = new CustomerDto(phone, name, point);
			int result = dao.insertCustomer(newCustomer);
			jta.setText(result==CustomerDao.SUCCESS? name+"님 가입성공":"가입실패");
			txtPhone.setText("");
			txtName.setText("");
			txtPoint.setText("1000");
		}else if(e.getSource() == btnSearch) {
			txtName.setText("");
			txtPoint.setText("");
			// 폰뒷4자리조회(풀 전화번호 조회)
			String searchPhone = txtPhone.getText().trim();
			if(searchPhone.length()<4) {
				jta.setText("폰번호는 4자리 이상 입력하셔야 합니다");
				return;
			}
			customers = dao.selectPhone(searchPhone);
			if(customers.size()==1) {
				String phone = customers.get(0).getPhone();
				String name  = customers.get(0).getName();
				int point    = customers.get(0).getPoint();
				txtPhone.setText(phone);
				txtName.setText(name);
				txtPoint.setText(String.valueOf(point));//int를 문자열로 바꿔서 setText함
			}else if(customers.size()>1) {
				jta.setText("번호.이름\t전화\t포인트\n");
				for(CustomerDto customer : customers) {
					jta.append(customer.toString()+"\n");
				}
			}else {
				jta.setText("검색되지 않는 전화번호입니다");
			}
		}else if(e.getSource() == btnOutput) {
			txtPhone.setText("");
			txtName.setText("");
			txtPoint.setText("");
			customers = dao.selectAll();
			if(customers.size()==0) {
				jta.append("등록된 회원이 없습니다");
			}else {
				jta.setText("번호.이름\t전화\t포인트\n");
				for(CustomerDto customer : customers) {
					jta.append(customer.toString()+"\n");
				}
			}
		}else if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}//if
	}//actionPerformed
	public static void main(String[] args) {
		new CustomerMng("회원관리");
	}
}
