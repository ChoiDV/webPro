package com.lec.ch07.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// board/write, board/content, board/list, board/reply

@Controller
@RequestMapping("board") // 공통요청경로
public class BoardController {
	@RequestMapping(value="write") // 조합된 요청경로 : board/writer
	public String write() {
		return "board/write"; // 뷰 : /WEB-INF/views/board/write.jsp
	}
	
}















