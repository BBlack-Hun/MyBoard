package com.mayfarm.service;

import java.util.List;

import com.mayfarm.vo.BoardVO;
import com.mayfarm.vo.Criteria;
import com.mayfarm.vo.SearchCriteria;

public interface BoardService {
	
	// 게시글 작성
	public void write(BoardVO boardVO) throws Exception;
	
	/**
	 * 게시물 목록 조회
	 * BoardDAO와 연결되는 service 작성
	 * @return
	 * @throws Exception
	 */
	public List<BoardVO> list(SearchCriteria scrl) throws Exception;
	
	/**
	 * 게시물 총 갯수
	 * @return
	 * @throws Exception
	 */
	public int listCount(SearchCriteria scrl) throws Exception;
	
	/**
	 * 게시물 조회
	 * 파라미터로 받은 no를 가지고 게시물을 조회
	 * @param no
	 * @return
	 * @throws Exception
	 */
	public BoardVO read(int no) throws Exception;
	/**
	 * 파라미터로 받은 boardVO(수정된 값)을 가지고 게시글 수정
	 * @param boardVO
	 * @throws Exception
	 */
	public void update(BoardVO boardVO) throws Exception;
	
	/**
	 * 파리미터로 받은 no(게시물 번호)를 가지고 게시물 삭제
	 * @param no
	 * @throws Exception
	 */
	public void delete(int no) throws Exception;
}
