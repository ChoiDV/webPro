package com.lec.ch07.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch07.dto.Member;
// board/write, board/content, board/list, board/reply
@Controller
@RequestMapping("board") // 공통요청경로
public class BoardController {
	@RequestMapping(value="write") // 조합된 요청경로 : board/writer
	public String write() {
		return "board/write"; // 뷰 : /WEB-INF/views/board/write.jsp
	}
	@RequestMapping(value="content", method=RequestMethod.GET)
	public String content(Model model/*, HttpServletRequest request*/) {
		// request.setAttribute("id", "aaa");
		model.addAttribute("id", "aaa");
		model.addAttribute("pw", "111");
		Member member = new Member("bbb", "222");
		model.addAttribute("member", member);
		return "board/content";
	}
}

















