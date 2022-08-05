package com.lec.ch17.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.ch17.dao.SeatDao;
@Controller
public class SeatController {
	@Autowired
	private SeatDao dao;
	@RequestMapping(value="reservation")
	public String reservation(Model model) {
		
		ArrayList<String> seatDbList = (ArrayList<String>) dao.seatList();
		ArrayList<String> seats = new ArrayList<String>();
		for(int i=0 ; i<10 ; i++) {
			if(seatDbList.contains("a"+(i+1))) {
				System.out.println("a"+(i+1)+"는 예약됨");
				seats.add("a"+i);
			}else {
				System.out.println("a"+(i+1)+"는 예약안 됨");
				seats.add("");
			}
		}
		model.addAttribute("seatDbList", seatDbList);
		model.addAttribute("seats", seats);
		return "seatReservation";
	}
	@RequestMapping(value="resultReservation")
	public String resultReservation(String[] seatId, Model model) {
		System.out.println(Arrays.toString(seatId));
		model.addAttribute("seats", seatId);
		return "resultReservation";
	}
}
