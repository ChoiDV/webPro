package com.lec.emp.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class EmpController {
//	@RequestMapping(value="/", method = RequestMethod.GET)
	@GetMapping("/")
	public String index() {
		log.info("welcome !");
		return "home";
	}
}










