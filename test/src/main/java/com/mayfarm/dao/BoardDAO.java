package com.mayfarm.dao;

import java.util.List;

import com.mayfarm.vo.BoardVO;
import com.mayfarm.vo.SearchCriteria;

public interface BoardDAO {
	
	// 게시글 작성
	public void write(BoardVO boardVO) throws Exception;
	
	// 게시물 조회
	public List<BoardVO> list(SearchCriteria scrl) throws Exception;
	
	// 게시물 총 갯수
	public int listCount(SearchCriteria scrl) throws Exception;
	
	// 게시물 조회
	public BoardVO read(int no) throws Exception;
	
	// 게시물 수정
	public void update(BoardVO boardVO) throws Exception;
	
	// 게시물 삭제
	public void delete(int no) throws Exception;
}
