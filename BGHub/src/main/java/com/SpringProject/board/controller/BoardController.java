package com.SpringProject.board.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SpringProject.board.service.BoardService;
import com.SpringProject.board.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/board/boardList.do")
	public String boardList(@ModelAttribute("boardVO")BoardVO boardVO, ModelMap model, HttpServletRequest request) throws Exception {
		//System.out.println("boardList - "+boardVO.toString());
		
		Map<String, Object> map = boardService.selectBoardList(boardVO);
		
		//System.out.println("map.get(\"resultList\") : "+map.get("resultList").toString());
		model.addAttribute("resultList", map.get("resultList"));
		return "/board/boardList";
	}
}
