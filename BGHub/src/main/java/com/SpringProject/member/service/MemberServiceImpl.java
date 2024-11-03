package com.SpringProject.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringProject.member.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDAO;
	
	@Override
	public Map<String, Object> selectMemberList() throws Exception{
		System.out.println("impl start selectMemberList");
		List<Map<String, Object>> result = memberDAO.selectMemberList();
		Map<String, Object> map = new HashMap<>();
		map.put("resultList", result);
		return map;
	}

	@Override
	public MemberVO findByEmail(String memberEmail) throws Exception {
		return memberDAO.findByEmail(memberEmail);
	}

	@Override
	public int insertMember(MemberVO memberVO) throws Exception {
		return memberDAO.insertMember(memberVO);
	}


}
