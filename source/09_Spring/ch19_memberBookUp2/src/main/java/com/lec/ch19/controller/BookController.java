package com.lec.ch19.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dto.Book;
import com.lec.ch19.service.BookService;
import com.lec.ch19.util.Paging;
@Controller
@RequestMapping(value = "book")
public class BookController {
	@Autowired
	private BookService bookService;
	@RequestMapping(value="registerForm", method=RequestMethod.GET)
	public String registerForm() {
		return "book/registerForm";
	}
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String register(MultipartHttpServletRequest mRequest, Book book, Model model) {
		model.addAttribute("registerResult", bookService.registerBook(mRequest, book));
		return "redirect:registerForm.do";
	}
	@RequestMapping(value="list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(String pageNum, Model model) {
		model.addAttribute("bookList", bookService.bookList(pageNum));
		model.addAttribute("paging", new Paging(bookService.totCntBook(), pageNum, 3, 3));
		return "book/list";		
	}
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String detail(int bnum, Model model) {
		model.addAttribute("bookDto", bookService.getDetailBook(bnum));
		return "book/detail";
	}
	@RequestMapping(value="modifyForm", method = RequestMethod.GET)
	public String modifyForm(int bnum, Model model) {
		model.addAttribute("bookDto", bookService.getDetailBook(bnum));
		return "book/modifyForm";
	}
	@RequestMapping(value="modify", method = RequestMethod.POST)
	public String modify(MultipartHttpServletRequest mRequest, @ModelAttribute("bDto") Book book, Model model, String pageNum) {
		model.addAttribute("modifyResult", bookService.modifyBook(mRequest, book));
		return "forward:list.do?pageNum="+pageNum;
	}
}