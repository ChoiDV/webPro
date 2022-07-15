package com.lec.ch10.vo;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
public class QuizValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		return Quiz.class.isAssignableFrom(clazz); // 검증할 객체의 클래스 타입 명시
	}
	@Override
	public void validate(Object target, Errors errors) {
		// 컨트롤러에서 호출 : validate(student, errors) 호출
		Quiz quiz = (Quiz)target;
		String name = quiz.getName();
		int kor = quiz.getKor();
		int eng = quiz.getEng();
		int mat = quiz.getMat();
		if(name.trim().isEmpty()) {
			errors.rejectValue("name", "no"); // name 에러 등록
		}
		if(kor<0 || kor>100) {
			errors.rejectValue("kor", "no"); // id 에러 등록
		}
		if(eng<0 || eng>100) {
			errors.rejectValue("eng", "no"); // id 에러 등록
		}
		if(mat<0 || mat>100) {
			errors.rejectValue("mat", "no"); // id 에러 등록
		}
	}
}