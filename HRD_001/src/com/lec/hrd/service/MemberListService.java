package com.lec.hrd.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.hrd.dao.MemberDao;

public class MemberListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao memberDao = new MemberDao();
		request.setAttribute("memberList", memberDao.memberList());

	}

}
