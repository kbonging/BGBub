package com.SpringProject.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SpringProject.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/member/memberList.do")
	public String memberList() throws Exception {
		Map<String, Object> map =memberService.selectMemberList();
		System.out.println("map.get(\"resultList\") : "+map.get("resultList").toString());
		return "redirect:/";
	}
}
