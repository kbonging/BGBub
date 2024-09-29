package com.SpringProject.board.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<Map<String, Object>> selectBoardList(){
		System.out.println("start BoardDAO - selectBoardList");
		return this.sqlSessionTemplate.selectList("BoardDAO.selectBoardList");
	}
}
