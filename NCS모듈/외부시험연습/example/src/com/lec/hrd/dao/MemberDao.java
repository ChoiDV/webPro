package com.lec.hrd.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lec.hrd.dto.MemberDto;

public class MemberDao {
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe",
				"scott","tiger");
		return conn;
	}
	public int getCustno() { // 회원등록시 등록될 회원번호 가져오기
		int custno = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT MAX(CUSTNO)+1 CUSTNO FROM MEMBER";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				custno     = rs.getInt("custno");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "getCustno 에러");
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {System.out.println(e.getMessage());}
		}
		return custno;
	}
	public ArrayList<MemberDto> memberList(){ // 회원목록
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT CUSTNO, CUSTNAME, PHONE, ADDRESS, to_char(JOINDATE,'YYYY-MM-DD') joindate, GRADE, CITY " + 
				"	FROM MEMBER";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int custno     = rs.getInt("custno");
				String custname= rs.getString("custname");
				String phone   = rs.getString("phone");
				String address = rs.getString("address");
				String   joindate=rs.getString("joindate");
				String grade   = rs.getString("grade");
				String city    = rs.getString("city");
				dtos.add(new MemberDto(custno, custname, phone, address, joindate, grade, city));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "listMember 에러");
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {System.out.println(e.getMessage());}
		}
		return dtos;
	}
	public int join(MemberDto member) { // 회원등록
		int result = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER (custno, custname, phone, address, joindate, grade, city) " + 
				"	VALUES (MEMBER_SQ.NEXTVAL, ?, ?, ?, TO_DATE(?,'YYYYMMDD'), ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getCustname());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getAddress());
			pstmt.setString(4, member.getJoindate());
			pstmt.setString(5, member.getGrade());
			pstmt.setString(6, member.getCity());
			result = pstmt.executeUpdate();
			System.out.println(result==1? "회원등록":"회원등록실패");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "회원등록실패 : " + member);
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {System.out.println(e.getMessage());}
		}
		return result;
	}
	public MemberDto getMember(int custno) { // 특정회원 조회
		MemberDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT CUSTNO, CUSTNAME, PHONE, ADDRESS, to_char(JOINDATE,'YYYYMMDD') joindate, grade, CITY " + 
				"    FROM  MEMBER  WHERE CUSTNO=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//int custno     = rs.getInt("custno");
				String custname= rs.getString("custname");
				String phone   = rs.getString("phone");
				String address = rs.getString("address");
				String   joindate=rs.getString("joindate");
				String grade   = rs.getString("grade");
				String city    = rs.getString("city");
				dto = new MemberDto(custno, custname, phone, address, joindate, grade, city);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "getMember 에러 : " +dto);
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {System.out.println(e.getMessage());}
		}
		return dto;
	}
	public int update(MemberDto member) { // 회원수정
		int result = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET CUSTNAME = ?," + 
				"				PHONE = ?," + 
				"				ADDRESS = ?," + 
				"				JOINDATE = TO_DATE(?,'YYYYMMDD')," + 
				"				GRADE = ?," + 
				"				CITY = ?" + 
				"			WHERE CUSTNO = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getCustname());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getAddress());
			pstmt.setString(4, member.getJoindate());
			pstmt.setString(5, member.getGrade());
			pstmt.setString(6, member.getCity());
			pstmt.setInt(7, member.getCustno());
			result = pstmt.executeUpdate();
			System.out.println(result==1? "회원수정 성공":"회원수정 실패");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "회원수정 실패 에러 : " +member);
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {System.out.println(e.getMessage());}
		}
		return result;
	}
}
