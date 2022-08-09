package com.lec.seat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.seat.dao.TimeDao;
import com.lec.seat.vo.TimeReservation;

@Controller
public class TimeController {
	@Autowired
	private TimeDao timeDao;
	@RequestMapping(value="timeReservation")
	public String timeReservation(Model model) {
		List<TimeReservation> timeList = timeDao.reservationList();
		model.addAttribute("timeList", timeList);
		return "timeReservation";
	}
}
