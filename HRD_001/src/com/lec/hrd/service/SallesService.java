package com.lec.hrd.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.hrd.dao.SalesDao;
import com.lec.hrd.dto.SalesDto;

public class SallesService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		SalesDao salesDao = new SalesDao();
		ArrayList<SalesDto> saleslist = salesDao.salesList();
		request.setAttribute("salesList", saleslist);
	}

}
