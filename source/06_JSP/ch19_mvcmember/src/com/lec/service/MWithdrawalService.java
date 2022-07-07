package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;

public class MWithdrawalService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String mId = ((MemberDto)session.getAttribute("member")).getmId();
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.withdrawal(mId);
		if(result == MemberDao.SUCCESS) {
			request.setAttribute("withdrawalResult", "회원탈퇴가 성공되었습니다");
		}else {
			request.setAttribute("withdrawalResult", "회원탈퇴가 실패되었습니다");
		}
		request.setAttribute("withdrawal", mDao.withdrawal(mId));
		session.invalidate();
	}

}
