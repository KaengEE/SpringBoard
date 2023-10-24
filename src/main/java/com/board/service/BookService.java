package com.board.service;

import java.util.List;

import com.board.domain.BookVO;

public interface BookService {

	List<BookVO> book() throws Exception;

}
