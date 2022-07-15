package com.lec.ch08.controller;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MyController {
	@ModelAttribute("cnt")
	public int cnt() {
		return 5;
	}
	@ModelAttribute("list")
	public ArrayList<String> list(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("test1");list.add("test2");
		return list;
	}
	@RequestMapping(value="/")
	public String input(Model model) {
		//model.addAttribute("cnt", 5);
		return "member/input";
	}
}







