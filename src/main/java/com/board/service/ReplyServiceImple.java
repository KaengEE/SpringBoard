package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.ReplyDAO;
import com.board.domain.ReplyVO;

@Service
public class ReplyServiceImple implements ReplyService{
	
	@Autowired
	private ReplyDAO dao;
	
	@Override
	public List<ReplyVO> list(int bno) throws Exception {
		return dao.list(bno);
	}

	@Override
	public void write(ReplyVO vo) throws Exception {
		dao.write(vo);
	}

	@Override
	public void modify(ReplyVO vo) throws Exception {
		dao.modify(vo);
	}

	@Override
	public void delete(ReplyVO vo) throws Exception {
		dao.delete(vo);
	}

	@Override
	public ReplyVO replySelect(ReplyVO vo) throws Exception {
		return dao.replySelect(vo);
	}

}
