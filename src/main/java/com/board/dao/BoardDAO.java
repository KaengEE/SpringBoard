package com.board.dao;

import java.util.List;

import com.board.domain.BoardVO;

public interface BoardDAO {
	
	public List<BoardVO> list() throws Exception;
	
	public void write(BoardVO vo) throws Exception; //리턴이 없으면 void
	
	public BoardVO view(int bno) throws Exception;
	
	public void modify(BoardVO vo) throws Exception;
	
	public void delete(int bno) throws Exception;
	
	public void viewCnt(int bno) throws Exception;
	
	public int count() throws Exception;
	
	public int searchCount(String searchType, String keyword) throws Exception;
	
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception;
	
	public List<BoardVO> listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception;
}
