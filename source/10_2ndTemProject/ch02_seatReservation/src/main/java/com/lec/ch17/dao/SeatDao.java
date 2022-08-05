package com.lec.ch17.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface SeatDao {
	public List<String> seatList();
}
