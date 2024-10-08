package com.SpringProject.board.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringProject.board.vo.BoardVO;

@Repository
public class BoardDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 게시판 목록 조회를 한다.
	 *
	 * @param BoardVO boardVO
	 * @return Map<String, Object>
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectBoardList(BoardVO boardVO){
		return this.sqlSessionTemplate.selectList("BoardDAO.selectBoardList", boardVO);
	}
}
