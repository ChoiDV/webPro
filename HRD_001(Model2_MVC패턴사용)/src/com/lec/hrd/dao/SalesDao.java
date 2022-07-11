package com.lec.hrd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lec.hrd.dto.MemberDto;
import com.lec.hrd.dto.SalesDto;

public class SalesDao {
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe",
				"scott","tiger");
		return conn;
	}
	public ArrayList<SalesDto> salesList(){ // 회원매출목록
		ArrayList<SalesDto> dtos = new ArrayList<SalesDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT MEMBER.CUSTNO, CUSTNAME, GRADENAME, PRICE " + 
				"	FROM MEMBER_TBL_02 MEMBER, MEMBERLEVEL ML, " + 
				"		(SELECT CUSTNO, SUM(PRICE) PRICE FROM MENEY_TBL_02 GROUP BY CUSTNO) SALES" + 
				"	WHERE MEMBER.CUSTNO = SALES.CUSTNO AND ML.GRADE=MEMBER.GRADE" + 
				"	ORDER BY PRICE DESC";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int custno = rs.getInt("custno");
				String custname = rs.getString("custname");
				String gradename = rs.getString("gradename");
				int price = rs.getInt("price");
				dtos.add(new SalesDto(custno, custname, gradename, price));
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
