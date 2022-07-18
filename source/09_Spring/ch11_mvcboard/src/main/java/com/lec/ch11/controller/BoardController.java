package com.lec.ch11.controller;
import org.springframework.stereotype.Controller;
// mvcboard/list.do, mvcboard/writeView.do, mvcboard/write.do, 
// mvcboard/content.do, mvcboard/modify.do, mvcboard/reply.do
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("mvcboard") // 공통요청경로
public class BoardController {
	@RequestMapping(value="/list")
	public String list() {
		return "mvcboard/list";
	}
}
