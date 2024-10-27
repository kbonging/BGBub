package com.SpringProject.main.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(value = "/main.do")
	public String main(HttpServletResponse response) {
		 // 캐시 방지 설정
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
		return "/main";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletResponse response) {
		 // 캐시 방지 설정
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
		return "redirect:/main.do";
	}

}
