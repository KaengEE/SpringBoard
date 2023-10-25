package com.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.domain.ReplyVO;
import com.board.service.ReplyService;

@Controller
@RequestMapping("/reply")
public class ReplyController {
	@Autowired
	private ReplyService replyservice;
	
	//댓글작성
	@PostMapping("/write")
	public String postWrite(ReplyVO vo) throws Exception {
		replyservice.write(vo);
		return "redirect:/board/view?bno="+vo.getBno();
	}

	//단일댓글조회 - 수정페이지표시
	@GetMapping("/modify")
	public void getModify(ReplyVO vo, Model model) throws Exception{
		ReplyVO reply = replyservice.replySelect(vo);
		model.addAttribute("reply", reply);
	}
	
	//댓글수정
	@PostMapping("/modify")
	public String postModify(ReplyVO vo) throws Exception{
		replyservice.modify(vo);
		return "redirect:/board/view?bno="+vo.getBno();
	}
	//댓글삭제
	@GetMapping("/delete")
	public String getDelete(ReplyVO vo) throws Exception{
		replyservice.delete(vo);
		return "redirect:/board/view?bno="+vo.getBno();
	}
	
}
