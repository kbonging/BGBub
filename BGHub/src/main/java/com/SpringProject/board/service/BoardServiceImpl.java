package com.SpringProject.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringProject.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public Map<String, Object> selectBoardList(BoardVO boardVO) throws Exception {
		List<Map<String, Object>> result = boardDAO.selectBoardList(boardVO);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("resultList", result);
		return map;
	}

}
