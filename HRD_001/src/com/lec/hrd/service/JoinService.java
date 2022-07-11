package com.lec.hrd.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.hrd.dao.MemberDao;
import com.lec.hrd.dto.MemberDto;

public class JoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int custno = Integer.parseInt(request.getParameter("custno"));
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joindate = request.getParameter("joindate");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		MemberDto member = new MemberDto(custno, custname, phone, address, joindate, grade, city);
		MemberDao memberDao = new MemberDao();
		request.setAttribute("joinResult", memberDao.join(member));
	}

}
