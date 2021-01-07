package com.mayfarm.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mayfarm.dao.BoardDAO;
import com.mayfarm.vo.BoardVO;
import com.mayfarm.vo.Criteria;
import com.mayfarm.vo.SearchCriteria;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	private BoardDAO dao;
	
	// 게시글 작성
	@Override
	public void write(BoardVO boardVO) throws Exception {
		dao.write(boardVO);
	}
	/**
	 * 게시물 목록 조회
	 * dao에 있는 list()함수를 호출해서 반환하겠다는 뜻.
	 */
	@Override
	public List<BoardVO> list(SearchCriteria scrl) throws Exception {
		
		return dao.list(scrl);
	}
	
	/**
	 * 게시물 총 갯수
	 */
	public int listCount(SearchCriteria scrl) throws Exception {
		return dao.listCount(scrl);
	}
	
	/**
	 * 게시물 조회
	 * dao에 있는 no에 해당하는 read함수를 호출하여 반환
	 */
	@Override
	public BoardVO read(int no) throws Exception {
		return dao.read(no);
	}
	/**
	 * 게시물 수정
	 */
	@Override
	public void update(BoardVO boardVO) throws Exception {
		dao.update(boardVO);
	}
	/**
	 * 게시물 삭제
	 */
	@Override
	public void delete(int no) throws Exception {
		
		dao.delete(no);
	}
}
