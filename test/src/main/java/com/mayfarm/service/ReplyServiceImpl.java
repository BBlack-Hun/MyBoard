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
		System.out.println("replyWrite");
		dao.writeReply(vo);
	}
}
