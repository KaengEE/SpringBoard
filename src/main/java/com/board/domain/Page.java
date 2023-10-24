package com.board.domain;

public class Page {
	// 현재 페이지 번호
	private int num;
	// 게시물 총 갯수
	private int count;
	// 한 페이지에 출력할 게시물 갯수
	private int postNum = 10;
	// 총 페이지 숫자
	private int pageNum;
	// 출력할 게시물
	private int displayPost;
	// 한번에 표시할 페이징 번호의 갯수
	private int pageNumCnt = 10;
	// 표시되는 페이지 번호 중 마지막 번호
	private int endPageNum;
	// 표시되는 페이지 번호 중 첫번째 번호
	private int startPageNum;
	// 다음/이전 표시 여부
	private boolean prev;
	private boolean next;
	
	
	//계산메서드
	public void dataCalc() {
		
		// 총페이지수 = 총게시글/10(한페이지 출력 개수)에서 반올림
		pageNum = (int)Math.ceil((double)count/postNum);
		
		// 출력할 게시글 첫페이지 0 두번째페이지 10 ...
		// 넘길 게시글
		displayPost = (num - 1) * postNum;
				
		// 마지막 번호
		endPageNum = (int)(Math.ceil((double)num / (double)pageNumCnt) * pageNumCnt);
		 
		// 시작 번호
		startPageNum = endPageNum - (pageNumCnt - 1);
		 
		 // 마지막 번호 재계산
		if(endPageNum > pageNum) {
		  endPageNum = pageNum;
		}
		 
		//시작페이지가 1이면 이전페이지 없음
		prev = startPageNum == 1 ? false : true;
		//마지막페이지가 총페이지보다 작으면 다음페이지 있음
		next = endPageNum < pageNum ? true : false;
		
	}
	
	
	//게터
	public int getNum() {
		return num;
	}
	public int getCount() {
		return count;
	}
	public int getPostNum() {
		return postNum;
	}
	public int getPageNum() {
		return pageNum;
	}
	public int getDisplayPost() {
		return displayPost;
	}
	public int getPageNumCnt() {
		return pageNumCnt;
	}
	public int getEndPageNum() {
		return endPageNum;
	}
	public int getStartPageNum() {
		return startPageNum;
	}
	public boolean isPrev() {
		return prev;
	}
	public boolean isNext() {
		return next;
	}
	
	//세터
	public void setNum(int num) {
		this.num = num;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
