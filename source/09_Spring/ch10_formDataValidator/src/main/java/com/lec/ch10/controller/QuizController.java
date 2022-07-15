package com.lec.ch10.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch10.vo.Quiz;
import com.lec.ch10.vo.QuizValidator;
@Controller
public class QuizController {
	@ModelAttribute("cnt")
	public int cnt() {
		return 4;
	}
	@RequestMapping(value="quizInput.do", method = RequestMethod.GET)
	public String quizInputForm() {
		return "quiz/quizInput";
	}
	@RequestMapping(value="quizInput.do", method = RequestMethod.POST)
	public String quizInputResult(Quiz quiz, Errors errors, Model model) {
		quiz.setSum(quiz.getKor()+quiz.getEng()+quiz.getMat());
		quiz.setAvg(quiz.getSum()/3.0);
		QuizValidator quizValidator = new QuizValidator();
		quizValidator.validate(quiz, errors);
		if(errors.hasErrors()) {
			if(errors.getFieldError("name") != null) {
				model.addAttribute("nameError", "name은 한글자 이상 필수 입력 사항입니다");
			}
			if(errors.getFieldError("kor") != null ||
					errors.getFieldError("eng") != null ||
					errors.getFieldError("mat") != null) {
				model.addAttribute("scoreError", "점수는 0~100점 사이입니다");
			}
			return "quiz/quizInput";
		}
		return "quiz/quizResult";
	}
}
