package com.lec.hrd.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.hrd.dao.MemberDao;

public class GetCustnoService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao memberDao = new MemberDao();
		request.setAttribute("custno", memberDao.getCustno());
		Date today = new Date(System.currentTimeMillis());
		request.setAttribute("today", today); // 오늘
	}
}
