package com.SpringProject.board.service;

import java.util.Map;

import com.SpringProject.board.vo.BoardVO;

public interface BoardService {
	
	/**
	 * 게시판 목록 조회를 한다.
	 *
	 * @param BoardVO boardVO
	 * @return Map<String, Object>
	 * @throws Exception
	 */
	Map<String, Object> selectBoardList(BoardVO boardVO) throws Exception;
}
