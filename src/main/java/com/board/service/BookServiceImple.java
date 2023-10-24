package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.dao.BookDAO;
import com.board.domain.BookVO;

@Service
public class BookServiceImple implements BookService{
	
	@Inject
	private BookDAO bookDAO;
	
	@Override
	public List<BookVO> book() throws Exception{
		return bookDAO.book();
	}
}
