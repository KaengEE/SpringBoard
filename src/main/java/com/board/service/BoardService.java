package com.board.service;

import java.util.List;

import com.board.domain.BoardVO;

public interface BoardService {
	//게시물 목록
	public List<BoardVO> list() throws Exception;
	//게시물 목록 + 페이징
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception;
	
	public void write(BoardVO vo) throws Exception;
	
	public BoardVO view(int bno) throws Exception;
	
	public void modify(BoardVO vo) throws Exception;
	
	public void delete(int bno) throws Exception;
	
	public void viewCnt(int bno) throws Exception;
	
	public int count() throws Exception;
	
	public List<BoardVO> listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception;
	
	public int searchCount(String searchType, String keyword) throws Exception;
}
