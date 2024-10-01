package com.SpringProject.member.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 회원 목록을 조회한다.
	 *
	 * @param 
	 * @return Map<String, Object>
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectMemberList(){
		System.out.println("start MemberDAO - selectMemberList");
		return this.sqlSessionTemplate.selectList("MemberDAO.selectMemberList");
	}
}
