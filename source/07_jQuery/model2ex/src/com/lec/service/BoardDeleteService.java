package com.lec.service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lec.dao.BoardDao;
public class BoardDeleteService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fGroup = Integer.parseInt(request.getParameter("fGroup"));
		int fStep = Integer.parseInt(request.getParameter("fStep"));
		int fIndent = Integer.parseInt(request.getParameter("fIndent"));
		BoardDao boardDao = BoardDao.getInstance();
		int result = boardDao.deleteBoard(fGroup, fStep, fIndent);
		if(result == BoardDao.SUCCESS) {
			request.setAttribute("boaredResult", "글삭제 성공");
		}else {
			request.setAttribute("boaredResult", "글삭제 실패");
		}
	}
}
