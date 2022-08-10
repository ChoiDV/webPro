package com.lec.alist.controller;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.alist.vo.Member;

@Controller
@RequestMapping("member")
public class MemberController {
	@ModelAttribute("list")
	public ArrayList<Member> list(){
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(new Member("홍길동","aaa","1"));
		list.add(new Member("신길동","bbb","2"));
		list.add(new Member("박유동","ccc","3"));
		return list;
	}
	@RequestMapping("input")
	public String input(Model model) {
		ArrayList<String> test = new ArrayList<String>();
		test.add("하");
		test.add("호");
		model.addAttribute("test", test);
		return "member/input";
	}
	@RequestMapping("join6")
	public String join6(@ModelAttribute("member") Member memberDto) {
		System.out.println(memberDto);
		return "member/result4";
	}
}


















