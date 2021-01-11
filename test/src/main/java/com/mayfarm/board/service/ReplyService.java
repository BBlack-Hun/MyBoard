package com.mayfarm.board.service;

import java.util.List;

import com.mayfarm.board.vo.ReplyVO;

public interface ReplyService {
	
	// 댓글 보기
	public List<ReplyVO> readReply(int no) throws Exception;
	
	// 댓글 쓰기
	public void writeReply(ReplyVO vo) throws Exception;
	
	// 댓글 수정
	public void updateReply(ReplyVO vo) throws Exception;
	
	// 댓글 삭제
	public void deleteReply(ReplyVO vo) throws Exception;
	
	// 선택한 댓글 조회
	public ReplyVO selectReply(int rno) throws Exception;
}
