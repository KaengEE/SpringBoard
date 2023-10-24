package com.board.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	//로그를 출력하기 위한 객체
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//getMapping("/")와 같음
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//로그 INFO(정보) 
		logger.info("클라이언트가 접속함. 클라이언트 위치는 {}", locale);
		
		Date date = new Date(); //현재 날짜객체
		//현지 날짜 형식에 맞게 포맷을 만듬
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		//포맷에 현재날짜를 입력하여 문자열 형식으로 만듬
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
