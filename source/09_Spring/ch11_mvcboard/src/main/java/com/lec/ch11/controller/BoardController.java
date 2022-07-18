package com.lec.ch11.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// mvcboard/list.do, mvcboard/writeView.do, mvcboard/write.do, 
// mvcboard/content.do, mvcboard/modify.do, mvcboard/reply.do
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch11.bservice.BListService;
import com.lec.ch11.bservice.Service;
@Controller
@RequestMapping("mvcboard") // 공통요청경로
public class BoardController {
	private Service bservice;
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(String pageNum, Model model) {
		// mvcboard/list.do?pageNum=2
		// mvcboard/list.do
		model.addAttribute("pageNum", pageNum);
		bservice = new BListService();
		bservice.execute(model);
		return "mvcboard/list";
	}
}
