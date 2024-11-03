package com.SpringProject.email.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SpringProject.email.service.EmailService;

@Controller
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;

	/* 이메일 전송 */
	@GetMapping("/sendEmail")
	@ResponseBody
	public ResponseEntity<Map<String, String>> sendEmail(@RequestParam String email, HttpSession session) {
		String randomCode = emailService.randomCode();
		
		Map<String, String> response = new HashMap<>();
	    try {
	    	// 이전 세션 값 삭제 (이메일 재전송 시)
	        session.removeAttribute("verificationEmail");
	        session.removeAttribute("verificationCode");
	        session.removeAttribute("verificationCodeTimestamp");
	        
	        String subject = "[BGHub]에서 보낸 인증번호입니다.";
	        String text =emailService.createEmailContent(randomCode);

	        //이메일 전송
	        emailService.sendEmail(email, subject, text);
	        
	        // 세션에 이메일과 인증 코드 저장
	        session.setAttribute("verificationEmail", email);
	        session.setAttribute("verificationCode", randomCode);
	        session.setAttribute("verificationCodeTimestamp", System.currentTimeMillis()); // 현재 시간 저장
	        
	        response.put("message", "이메일이 발송되었습니다! 받은 편지함을 확인해 주세요."); // 성공 메시지
	        return ResponseEntity.ok(response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.put("error", "유효한 이메일인지 확인해 주세요.\n문의사항은 고객센터(1544-1234)로 문의해 주세요."); // 에러 메시지
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // JSON 객체 반환
	    }
	}
	
	/* 이메일 인증 */
	@PostMapping("/verifyCode")
	@ResponseBody
	public ResponseEntity<Boolean> verifyCode(@RequestParam String email, @RequestParam String code, HttpSession session) {
	    String storedCode = (String) session.getAttribute("verificationCode");
	    String storedEmail = (String) session.getAttribute("verificationEmail");
	    Long timestamp = (Long) session.getAttribute("verificationCodeTimestamp");
	    boolean result = false;
	    // 만료 시간 체크 (5분 = 300000 milliseconds)
	    if (timestamp != null && (System.currentTimeMillis() - timestamp) > 300000) { // 5분이 경과했는지 확인
	        session.removeAttribute("verificationEmail");
	        session.removeAttribute("verificationCode");
	        session.removeAttribute("verificationCodeTimestamp");
	        result = false; // 코드 만료
	    }

	    // 이메일 비교
	    if (storedEmail == null || !storedEmail.equals(email)) {
	    	result = false; // 이메일 불일치
	    }

	    // 인증 코드 비교
	    result = storedCode != null && storedCode.equals(code);
	    return ResponseEntity.ok(result);
	}

}
