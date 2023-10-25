package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.BoardVO;
import com.board.domain.Page;
import com.board.domain.ReplyVO;
import com.board.service.BoardService;
import com.board.service.ReplyService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService; 
	
	@Autowired
	private ReplyService replyService;
	
	//목록페이지
	/* @RequestMapping(value = "/list", method = RequestMethod.GET) */
	@GetMapping("/list")
	public void getList(Model model) throws Exception {
		//void리턴시에 주소값과 같은 .jsp를 찾는다 => board/list.jsp
		List<BoardVO> list = boardService.list();
		model.addAttribute("list",list);
	}
	
	//게시글 목록 + 페이징
	@GetMapping("/listPage")
	public void getListPage(@RequestParam("num") int num, Model model) throws Exception {
		// 게시글 총 개수 
		int count = boardService.count();
		
		Page page = new Page();
		page.setNum(num);
		page.setCount(count);
		page.dataCalc(); //페이지와 총게시글로 계산

		List<BoardVO> list = boardService.listPage(page.getDisplayPost(),page.getPostNum());
		model.addAttribute("list",list); //현재 페이지(num페이지)의 데이터
		model.addAttribute("page", page); //페이지 객체
		model.addAttribute("select", num); //현재 선택 페이지
	}

	//게시글 목록 + 페이징 + 검색
	@GetMapping("/listPageSearch")
	public void getListPageSearch(@RequestParam(value = "num", required = false, defaultValue = "1") int num,
			                      @RequestParam(value = "searchType", required = false, defaultValue = "title") String searchType,
			                      @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
			                      Model model) throws Exception {
		
		// 게시글 총 개수 - 키워드와 서치타입이 들어가야함
		int count = boardService.searchCount(searchType, keyword);
		
		
		Page page = new Page();
		page.setNum(num);
		page.setCount(count);
		page.dataCalc(); //페이지와 총게시글로 계산

		List<BoardVO> list = boardService.listPageSearch(page.getDisplayPost(),
										  page.getPostNum(),searchType, keyword);
		model.addAttribute("list",list); //현재 페이지(num페이지)의 데이터
		model.addAttribute("page", page); //페이지 객체
		model.addAttribute("select", num); //현재 선택 페이지
		model.addAttribute("serchType",searchType);
		model.addAttribute("keyword",keyword);
		
	}

	
	
	@GetMapping("/write")
	public void getWirte() throws Exception {
		
	}
	
	//게시물 작성
	@PostMapping("/write")
	public String getWirte(BoardVO vo) throws Exception {
		boardService.write(vo); //테이블 저장
		return "redirect:/board/list"; //목록으로
	}
	
	//게시물 VIEW
	@GetMapping("/view")
	public void getView(@RequestParam("bno") int bno, Model model) throws Exception {
		BoardVO vo = boardService.view(bno); 
		model.addAttribute("view", vo);
		//댓글 조회
		List<ReplyVO> replyList = replyService.list(bno);
		model.addAttribute("reply", replyList);
	}
	
	//수정페이지
	@GetMapping("/modify")
	public void getModify(@RequestParam("bno") int bno, Model model) throws Exception {
		BoardVO vo = boardService.view(bno);
		model.addAttribute("view", vo);
	}
	
	@PostMapping("/modify")
	public String getmodify(BoardVO vo) throws Exception {
		boardService.modify(vo);
		return "redirect:/board/view?bno="+vo.getBno(); //뷰페이지로 이동
	}
	
	//삭제
	@GetMapping("/delete")
	public String getDelete(@RequestParam("bno") int bno) throws Exception {
		boardService.delete(bno);
		return "redirect:/board/list"; //삭제 후 목록페이지
	}
	
}
