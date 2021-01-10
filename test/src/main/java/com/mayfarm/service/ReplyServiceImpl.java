package com.mayfarm.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mayfarm.dao.ReplyDAO;
import com.mayfarm.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Inject
	private ReplyDAO dao;
	
	public List<ReplyVO> readReply(int no) throws Exception {
		return dao.readReply(no);
	}
	
	public void writeReply(ReplyVO vo) throws Exception {
		dao.writeReply(vo);
	}
	
	public void updateReply(ReplyVO vo) throws Exception {
		dao.updateReply(vo);
	}
	
	public void deleteReply(ReplyVO vo) throws Exception {
		dao.deleteReply(vo);
	}
	
	public ReplyVO selectReply(int rno) throws Exception {
		return dao.selectReply(rno);
	}
}
