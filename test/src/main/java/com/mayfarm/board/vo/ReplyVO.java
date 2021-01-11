package com.mayfarm.board.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	
	private int no;
	private int rno;
	private String content;
	private String writer;
	private Date regDt;
	
}
