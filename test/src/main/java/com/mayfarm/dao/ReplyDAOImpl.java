package com.mayfarm.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mayfarm.vo.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	
	@Inject
	SqlSession sql;
	/**
	 * 파리미터로 no을 넘겨서 sqlMapper의 ID가 readReply인 쿼리문을 실행하여 결과를 반환.
	 * 결과는 List 값!
	 * @param no
	 * @return
	 * @throws Exception
	 */
	public List<ReplyVO> readReply(int no) throws Exception {
		return sql.selectList("replyMapper.readReply", no);
	}
	/**
	 * vo를 파라미터로 하여 sql로 insert명령어를 날린다.
	 * vo는 사용자로부터 입력받은 값을 가지고 있다.
	 * @param vo
	 * @throws Exception
	 */
	public void writeReply(ReplyVO vo ) throws Exception {
		sql.insert("replyMapper.writeReply", vo);
	}
	
	/**
	 * vo를 파라미터로 하여 sql로 update 명령어를 날린다.
	 * vo는 사용자로부터 입력 받은 값을 가지고 있다.
	 * @param vo
	 * @throws Exception
	 */
	public void updateReply(ReplyVO vo) throws Exception {
		sql.update("replyMapper.updateReply", vo);
	}
	
	/**
	 * vo를 파라미터로 하여 sql로 delete 명령어를 날린다.
	 * vo는 해당 게시글의 rno를 가지고 있다.
	 */
	public void deleteReply(ReplyVO vo) throws Exception {
		sql.delete("repplyMapper.deleteReply", vo);
	}
	
	public ReplyVO selectReply(int rno) throws Exception {
		return sql.selectOne("replyMapper.selectReply", rno);
	}
	
	
}
