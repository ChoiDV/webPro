package com.lec.ch19sch.dto;
import java.sql.Date;
import lombok.Data;
@Data
public class Book {
	private int    bnum;
	private String btitle;
	private String bwriter;
	private Date   brdate; // 출판일
	private String bimg1;
	private String bimg2;
	private String binfo;
	private int startRow;
	private int endRow;
	private String schItem; // 검색하려고 선택된 항목 (책이름=btitle or 저자=bwriter)
	private String schWord; // 검색할 단어
}
