package com.SpringProject.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SpringProject.board.service.BoardDAO;

@Controller
public class BoardController {

	@Autowired
	BoardDAO boardDAO;
	
	@RequestMapping(value = "/board/boardList.do")
	public String boardList() {
		System.out.println(boardDAO.selectBoardList().toString());
		return "/board/boardList";
	}
}
