package com.lec.snedit.dto;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ReplyDto {
	private int rno;
	private int bno;
	private String rcontent;
	private String rip;
	private Timestamp rdate;
	public ReplyDto(int rno, int bno, String rcontent, String rip, Timestamp rdate) {
		super();
		this.rno = rno;
		this.bno = bno;
		this.rcontent = rcontent;
		this.rip = rip;
		this.rdate = rdate;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRip() {
		return rip;
	}
	public void setRip(String rip) {
		this.rip = rip;
	}
	public Timestamp getRdate() {
		return rdate;
	}
	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}
}
