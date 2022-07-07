package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.Dao;
import com.lec.ex.dto.Dto;

public class ModifyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String no = request.getParameter("no");
		Dao dao = new Dao();
		request.setAttribute("modifyDto", dao.getBoard(no));
	}

}
