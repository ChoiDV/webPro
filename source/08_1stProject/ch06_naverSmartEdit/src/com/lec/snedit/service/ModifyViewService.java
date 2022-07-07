package com.lec.snedit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.snedit.dao.BDao;
import com.lec.snedit.dto.BDto;

public class ModifyViewService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bno = Integer.parseInt(request.getParameter("bno"));
		BDao bDao = new BDao();
		request.setAttribute("dto", bDao.getDto(bno));
	}
}
