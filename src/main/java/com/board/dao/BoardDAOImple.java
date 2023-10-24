package com.board.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.domain.BoardVO;

//자동객체 생성
@Repository
public class BoardDAOImple implements BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlTemplate;
	
	@Override
	public List<BoardVO> list() throws Exception {
		// tbl_board의 모든 게시글을 가져옴
		return sqlTemplate.selectList("board.list");
	}

	@Override
	public void write(BoardVO vo) throws Exception {
		sqlTemplate.insert("board.write", vo); //입력값 vo 필요
		
	}

	@Override
	public BoardVO view(int bno) throws Exception {
		return sqlTemplate.selectOne("board.view", bno); //파라미터 입력값 bno
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		sqlTemplate.update("board.modify", vo); //파라미터 입력값 vo
	}
	//수정 삭제 입력은 sql문 수행하고 나서 몇행이 수정/삭제/입력 되었는가가 리턴됨(리턴숫자값이 있긴함)
	@Override
	public void delete(int bno) throws Exception {
		sqlTemplate.delete("board.delete", bno); //파라미터 입력값 bno
	}

	@Override
	public void viewCnt(int bno) throws Exception {
		sqlTemplate.update("board.viewCnt", bno);
		
	}

	@Override
	public int count() throws Exception {
		return sqlTemplate.selectOne("board.count");
	}

	@Override
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();
		 data.put("displayPost", displayPost);
		 data.put("postNum", postNum);
		return sqlTemplate.selectList("board.listPage", data);
	}

	@Override
	public List<BoardVO> listPageSearch(int displayPost, int postNum, String searchType, String keyword)
			throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();
		 data.put("displayPost", displayPost);
		 data.put("postNum", postNum);
		 data.put("searchType", searchType);
		 data.put("keyword", keyword);
		return sqlTemplate.selectList("board.listPageSearch", data);
	}

	@Override
	public int searchCount(String searchType, String keyword) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();
		 data.put("searchType", searchType);
		 data.put("keyword", keyword);
		return sqlTemplate.selectOne("board.searchCount", data);
	}

}
