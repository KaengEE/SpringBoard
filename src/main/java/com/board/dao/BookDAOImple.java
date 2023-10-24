package com.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.domain.BookVO;

//자동객체 생성
@Repository
public class BookDAOImple implements BookDAO {
	
	@Autowired
	private SqlSessionTemplate sqlTemplate;
	
	@Override
	public List<BookVO> book() throws Exception {
		// tbl_board의 모든 게시글을 가져옴
		return sqlTemplate.selectList("board.book");
	}

}
