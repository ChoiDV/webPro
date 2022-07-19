package com.lec.ch12.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.lec.ch12.dto.BoardDto;
import com.lec.ch12.util.Constant;
public class BoardDao {
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	public JdbcTemplate template;
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	private BoardDao() {
		template = Constant.template;
	}
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	// 글목록
	public ArrayList<BoardDto> boardList(){
		String sql = "SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP";
		return (ArrayList<BoardDto>) template.query(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
	}
	public ArrayList<BoardDto> boardList(final int startRow, final int endRow){
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* " + 
				"           FROM (SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP) A)" + 
				"    WHERE RN BETWEEN ? AND ?";
		return (ArrayList<BoardDto>) template.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
			}
		}, 
		new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
	}
	// 글 갯수 
	public int getBoardTotCnt() {
		String sql = "SELECT COUNT(*) FROM MVC_BOARD";
		return template.queryForObject(sql, Integer.class);
	}
	//원글쓰기
	public int write(final BoardDto bDto) {
		String sql = "INSERT INTO MVC_BOARD "
				+ "(bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)" + 
				"    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, " + 
				"            MVC_BOARD_SEQ.CURRVAL, 0,0, ?)";
		return template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, bDto.getBname());
				pstmt.setString(2, bDto.getBtitle());
				pstmt.setString(3, bDto.getBcontent());
				pstmt.setString(4, bDto.getBip());
				
			}
		});
	}
	// hit수 올리기
	private void hitUp(int bid) {
		String sql = "UPDATE MVC_BOARD SET BHIT = BHIT+1 WHERE BID="+bid;
		template.update(sql);
		
	}
	// 글 상세보기(글 상세볼 때 조회수도 올림)
	public BoardDto contentView(int bid) {
		hitUp(bid);
		String sql = "SELECT * FROM MVC_BOARD WHERE BID="+bid;
		return template.queryForObject(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
	}
	// bid로 dto 가져오기 (답글쓰기 + 수정)
	public BoardDto modifyView_replyView(int bid) {
		String sql = "SELECT * FROM MVC_BOARD WHERE BID="+bid;
		return template.queryForObject(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
	}
	// 글 수정하기
	public int modify(BoardDto bDto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_BOARD SET BNAME=?, " + 
				"                    BTITLE = ?, " + 
				"                    BCONTENT = ?, " + 
				"                    BIP = ?" + 
				"        WHERE BID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getBname());
			pstmt.setString(2, bDto.getBtitle());
			pstmt.setString(3, bDto.getBcontent());
			pstmt.setString(4, bDto.getBip());
			pstmt.setInt(5, bDto.getBid());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "글수정 성공":"글수정 실패");
		} catch (SQLException e) {
			System.out.println("글수정 실패 예외 : "+e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 글 삭제
	public int delete(int bid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM MVC_BOARD WHERE BID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? bid+"번 글삭제 성공":bid+"번글 삭제실패");
		} catch (SQLException e) {
			System.out.println("글삭제 예외 : "+e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 답변글 쓰기 전 작업 : stepA
	private void preReplyStepA(int bgroup, int bstep) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_BOARD SET BSTEP = BSTEP+1 WHERE BGROUP=? AND BSTEP>?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bgroup);
			pstmt.setInt(2, bstep);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("답변글 쓰기 전 작업 예외 : "+e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	// 답변글 쓰기
	public int reply(BoardDto bDto) { // bname, btitle, bcontent, bip : 답변글에 대한 정보
		                             // bgroup, bstep, bindent : 원글에 대한 정보
		preReplyStepA(bDto.getBgroup(), bDto.getBstep());
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVC_BOARD" + 
				" (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP) " + 
				"    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?,?,?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getBname());
			pstmt.setString(2, bDto.getBtitle());
			pstmt.setString(3, bDto.getBcontent());
			pstmt.setInt(4, bDto.getBgroup());
			pstmt.setInt(5, bDto.getBstep()+1);
			pstmt.setInt(6, bDto.getBindent()+1);
			pstmt.setString(7, bDto.getBip());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "답변쓰기 성공":"답변쓰기 실패");
		} catch (SQLException e) {
			System.out.println("답변쓰기 실패 예외 : "+e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
}