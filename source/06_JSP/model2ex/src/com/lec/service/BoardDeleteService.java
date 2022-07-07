package com.lec.service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lec.dao.BoardDao;
public class BoardDeleteService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fId = Integer.parseInt(request.getParameter("fId"));
		BoardDao boardDao = BoardDao.getInstance();
		int result = boardDao.deleteBoard(fId);
		if(result == BoardDao.SUCCESS) {
			request.setAttribute("boaredResult", "글삭제 성공");
		}else {
			request.setAttribute("boaredResult", "글삭제 실패");
		}
	}
}
