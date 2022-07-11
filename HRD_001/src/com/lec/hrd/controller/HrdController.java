package com.lec.hrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.hrd.service.GetCustnoService;
import com.lec.hrd.service.GetMemberService;
import com.lec.hrd.service.JoinService;
import com.lec.hrd.service.MemberListService;
import com.lec.hrd.service.SallesService;
import com.lec.hrd.service.Service;
import com.lec.hrd.service.UpdateService;
@WebServlet("*.do")
public class HrdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com     = uri.substring(conPath.length()); // 들어온 요청
		String viewPage = null;
		Service service = null;
		if(com.equals("/main.do")) {
			viewPage = "index.jsp";
		}else if(com.equals("/joinView.do")) {
			service = new GetCustnoService();
			service.execute(request, response);
			viewPage = "join.jsp";
		}else if(com.equals("/join.do")) {
			service = new JoinService();
			service.execute(request, response);
			viewPage = "memberList.do";
		}else if(com.equals("/memberList.do")) {
			service = new MemberListService();
			service.execute(request, response);
			viewPage = "memberList.jsp";
		}else if(com.equals("/getMember.do")) {
			service = new GetMemberService();
			service.execute(request, response);
			viewPage = "update.jsp";
		}else if(com.equals("/update.do")) {
			service = new UpdateService();
			service.execute(request, response);
			viewPage = "getMember.do";
		}else if(com.equals("/salesList.do")) {
			service = new SallesService();
			service.execute(request, response);
			viewPage = "salesList.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
