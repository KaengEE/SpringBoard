package com.board.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.board.dao.BoardDAO;
import com.board.domain.BoardVO;

@Service
public class BoardServiceImple implements BoardService{
	
	@Inject
	private BoardDAO boardDAO;
	
	
	@Override
	public List<BoardVO> list() throws Exception{
		return boardDAO.list();
	}

	@Override
	public void write(BoardVO vo) throws Exception {
		boardDAO.write(vo);
	}
	
	//게시물 조회시 viewCnt 증가
	@Override
	public BoardVO view(int bno) throws Exception {
		boardDAO.viewCnt(bno); //게시물 조회
		return boardDAO.view(bno);
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		boardDAO.modify(vo);	
	}

	@Override
	public void delete(int bno) throws Exception {
		boardDAO.delete(bno);
	}

	@Override
	public void viewCnt(int bno) throws Exception {
		boardDAO.viewCnt(bno);
		
	}

	@Override
	public int count() throws Exception {
		return boardDAO.count();
	}

	@Override
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception {
		return boardDAO.listPage(displayPost, postNum);
	}

	@Override
	public List<BoardVO> listPageSearch(int displayPost, int postNum, String searchType, String keyword)
			throws Exception {
		return boardDAO.listPageSearch(displayPost, postNum, searchType, keyword);
	}

	@Override
	public int searchCount(String searchType, String keyword) throws Exception {
		return boardDAO.searchCount(searchType, keyword);
	}
	
}
