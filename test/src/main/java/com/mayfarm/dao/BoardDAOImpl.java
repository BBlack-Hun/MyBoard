package com.mayfarm.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mayfarm.vo.BoardVO;
import com.mayfarm.vo.Criteria;
import com.mayfarm.vo.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	/**
	 * 게시물 작성
	 * boardMapper의 id가 insert인 것을 실행하라.
	 */
	@Override
	public void write(BoardVO boardVO) throws Exception {
		sqlSession.insert("boardMapper.insert", boardVO);
		
	}
	
	/**
	 * 게시물 목록 조회
	 * BoardMapper의 id가 list인 것을 가져와서 반환하라.
	 */
	@Override
	public List<BoardVO> list(SearchCriteria scrl) throws Exception {
			
		return sqlSession.selectList("boardMapper.listPage", scrl);
	}
	
	/**
	 * 게시물 총 갯수
	 */
	@Override
	public int listCount(SearchCriteria scrl) throws Exception {
		return sqlSession.selectOne("boardMapper.listCount", scrl);
	}
	
	/**
	 * 게시물 조회
	 * 파라미터로 받은 숫자의 BoardMapper의 id가 read 및 \
	 * 해당 no인 것을 가져와서 반환하라.
	 */
	@Override
	public BoardVO read(int no) throws Exception {
		return sqlSession.selectOne("boardMapper.read", no);
	}
	
	/**
	 * 게시물 수정
	 * 파라미터(boardVO)로 받은 값을 가지고 boardMapper의 update를 실행
	 */
	@Override
	public void update(BoardVO boardVO) throws Exception {
		sqlSession.update("boardMapper.update", boardVO);
	}
	
	/**
	 * 게시물 삭제
	 * 파라미터(no)로 받은 값을 가지고 해당 no에 해당하는 게시물 삭제를
	 * boardMapper의 delete를 통해 실행
	 */
	@Override
	public void delete(int no) throws Exception {
		sqlSession.delete("boardMapper.delete", no);
	}
}
