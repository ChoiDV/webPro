package com.lec.hrd.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.hrd.dao.MemberDao;
import com.lec.hrd.dto.MemberDto;

public class GetMemberService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int custno = Integer.parseInt(request.getParameter("custno"));
		MemberDao memberDao = new MemberDao();
		MemberDto dto = memberDao.getMember(custno);
		request.setAttribute("dto", dto);
	}

}
