package com.board.dao;

import java.util.List;

import com.board.domain.BookVO;

public interface BookDAO {
	
	public List<BookVO> book() throws Exception;
	
}
