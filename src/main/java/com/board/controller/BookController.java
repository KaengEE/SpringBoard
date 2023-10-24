package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.domain.BookVO;
import com.board.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService; 
	
	/* @RequestMapping(value = "/list", method = RequestMethod.GET) */
	@GetMapping("/list")
	public void getList(Model model) throws Exception {
		//void리턴시에 주소값과 같은 .jsp를 찾는다 => book/list.jsp
		List<BookVO> book = bookService.book();
		model.addAttribute("book",book);
	}
	
}
