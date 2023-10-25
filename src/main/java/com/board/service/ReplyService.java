package com.board.service;

import java.util.List;

import com.board.domain.ReplyVO;

public interface ReplyService {
	//조회
	public List<ReplyVO> list(int bno) throws Exception;
	//단일조회
	public ReplyVO replySelect(ReplyVO vo) throws Exception;
	//작성
	public void write(ReplyVO vo) throws Exception;
	//수정
	public void modify(ReplyVO vo) throws Exception;
	//삭제
	public void delete(ReplyVO vo) throws Exception;
}
