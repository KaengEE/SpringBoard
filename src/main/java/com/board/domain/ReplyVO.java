package com.board.domain;

import java.util.Date;

public class ReplyVO {
	/*
		CREATE TABLE tbl_reply (
			rno 		int 			not null auto_increment,
			bno 		int unsigned not null,
			writer 	varchar(30) not null,
			content 	text 			not null,
			regDate 	timestamp 	not null default now(),
			PRIMARY KEY(rno),
			FOREIGN KEY(bno) REFERENCES tbl_board(bno)
		);
	 */
	
	private int rno;
	private int bno;
	private String writer;
	private String content;
	private Date regDate;
	
	//게터세터
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}
