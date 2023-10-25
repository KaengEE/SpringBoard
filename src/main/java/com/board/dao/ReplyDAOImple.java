package com.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.domain.ReplyVO;

@Repository
public class ReplyDAOImple implements ReplyDAO {

	@Autowired
	private SqlSessionTemplate sqlTemplate;
	
	//댓글조회
	@Override
	public List<ReplyVO> list(int bno) throws Exception {
		return sqlTemplate.selectList("reply.replyList",bno);
	}
	//댓글작성
	@Override
	public void write(ReplyVO vo) throws Exception {
		sqlTemplate.insert("reply.replyWrite",vo);
	}
	//댓글수정
	@Override
	public void modify(ReplyVO vo) throws Exception {
		sqlTemplate.update("reply.replyModify", vo);
	}
	//댓글삭제
	@Override
	public void delete(ReplyVO vo) throws Exception {
		sqlTemplate.delete("reply.replyDelete", vo);

	}
	@Override
	public ReplyVO replySelect(ReplyVO vo) throws Exception {
		return sqlTemplate.selectOne("reply.replySelect", vo);
	}

}
