package com.mayfarm.service;

import com.mayfarm.vo.ReplyVO;

import java.util.List;

public interface ReplyService {
	
	// 댓글 보기
	public List<ReplyVO> readReply(int no) throws Exception;
	
	// 댓글 쓰기
	public void writeReply(ReplyVO vo) throws Exception;
}
