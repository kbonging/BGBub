package com.SpringProject.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringProject.member.service.MemberService;
import com.SpringProject.member.vo.MemberVO;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/member/memberList.do")
    public String memberList() throws Exception {
        Map<String, Object> map = memberService.selectMemberList();
        System.out.println("map.get(\"resultList\") : " + map.get("resultList").toString());
        return "redirect:/";
    }

    @GetMapping("/member/login.do")
    public String login() throws Exception {
        return "/member/login";
    }

    @PostMapping("/member/login.do") // POST 요청 처리
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
    	System.out.println(username);
    	System.out.println(password);
    	MemberVO memberVO = memberService.findByEmail(username);
    	System.out.println(memberVO);
    	return null;
    }

}
