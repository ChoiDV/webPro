package com.lec.hrd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lec.hrd.dto.MoneyDto;

public class MoneyDao {
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe",
				"scott","tiger");
		return conn;
	}
	public ArrayList<MoneyDto> salesList(){ // 회원매출목록
		ArrayList<MoneyDto> dtos = new ArrayList<MoneyDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT M.CUSTNO, CUSTNAME, GRADENAME, PRICE "
				+ "	FROM MEMBER M, MEMBERLEVEL ML, (SELECT CUSTNO, SUM(PRICE) PRICE FROM MONEY GROUP BY CUSTNO) SALES "
				+ "	WHERE M.CUSTNO = SALES.CUSTNO AND M.GRADE=ML.GRADE ORDER BY PRICE DESC";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int custno = rs.getInt("custno");
				String custname = rs.getString("custname");
				String gradename = rs.getString("gradename");
				int price = rs.getInt("price");
				dtos.add(new MoneyDto(custno, custname, gradename, null, price));
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
	public ArrayList<MoneyDto> hotProductList(){ // 제품매출목록
		ArrayList<MoneyDto> dtos = new ArrayList<MoneyDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT PCODE, SUM(PRICE) PRICE FROM MONEY GROUP BY PCODE ORDER BY PRICE DESC";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String pcode = rs.getString("pcode");
				int price = rs.getInt("price");
				dtos.add(new MoneyDto(0, null, null, pcode, price));
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
}
