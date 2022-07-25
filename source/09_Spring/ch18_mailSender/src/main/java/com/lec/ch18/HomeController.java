package com.lec.ch18;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class HomeController {
	@Autowired
	private JavaMailSender mailSender;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "join";
	}	
	@RequestMapping(value = "textMail", method = RequestMethod.GET)
	public String textMail(String name, String email, Model model) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("spacenyi0@gmail.com"); // 관리자 메일 주소(보내는 사람 메일)
		message.setTo(email); // 받는 사람 메일
		message.setSubject("[TEXT 가입인사]"+name+"님 회원가입 감사합니다"); // 메일 제목
		String content = name + "님 회원가입 감사합니다\n <h1>태그 안 먹음</h1>";
		message.setText(content); // 메일 본문 내용
		
		mailSender.send(message); // 메일 보내기
		model.addAttribute("mailSendResult", "TEXT메일이 발송되었습니다");
		return "sendResult";
	}
	@RequestMapping(value = "htmlMail", method = RequestMethod.GET)
	public String htmlMail(String name, String email, Model model) {
		// name에게 email 주소로 html 내용 보내기
		
		return "sendResult";
	}
}






























