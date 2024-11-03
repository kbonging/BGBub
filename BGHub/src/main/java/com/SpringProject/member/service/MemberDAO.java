package com.SpringProject.member.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringProject.member.vo.MemberVO;

@Repository
public class MemberDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	/* 회원 목록을 조회한다. */
	public List<Map<String, Object>> selectMemberList() throws Exception{
		System.out.println("start MemberDAO - selectMemberList");
		return this.sqlSessionTemplate.selectList("MemberDAO.selectMemberList");
	}
	
	 /* 이메일로 회원 정보를 조회한다. */
    public MemberVO findByEmail(String memberEmail) throws Exception{
        return this.sqlSessionTemplate.selectOne("MemberDAO.findByEmail", memberEmail);
    }
    
    /*회원 등록처리 */
    public int insertMember(MemberVO memberVO) throws Exception{
    	return this.sqlSessionTemplate.insert("MemberDAO.insertMember", memberVO);
    }
}
