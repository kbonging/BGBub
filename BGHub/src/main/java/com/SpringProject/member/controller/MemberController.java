package com.SpringProject.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SpringProject.member.service.MemberService;
import com.SpringProject.member.vo.MemberVO;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;
    
    @Autowired
    private PasswordEncoder passwordEncoder; // PasswordEncoder 주입
    
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);


    @RequestMapping(value = "/member/memberList.do")
    public String memberList() throws Exception {
        Map<String, Object> map = memberService.selectMemberList();
        System.out.println("map.get(\"resultList\") : " + map.get("resultList").toString());
        return "redirect:/";
    }

    /* 로그인 페이지로 이동 */
    @GetMapping("/member/login.do")
    public String login() throws Exception {
        return "/member/login";
    }

    /* 로그인 처리 */
    @PostMapping("/member/login.do") // POST 요청 처리
    public String login(@ModelAttribute("memberVO") MemberVO memberVO, Model model, HttpSession session, 
    		HttpServletRequest request, HttpServletResponse response) throws Exception {
    	//System.out.println("/member/login.do -"+memberVO.toString());
    	String url = "/member/login.do", msg = "아이디(로그인 전화번호, 로그인 전용 아이디) 또는 비밀번호가 잘못 되었습니다. 아이디와 비밀번호를 정확히 입력해 주세요. ";
    	
    	 // 기존 세션이 있으면 세션을 무효화합니다.
        if (session != null) {
            session.invalidate(); // 기존 세션을 삭제
        }
        // 새로운 세션을 생성합니다.
        session = request.getSession(true); // 새로운 세션 생성
        
    	MemberVO resultVO = memberService.findByEmail(memberVO.getMemberEmail());
    	if(resultVO != null) {
    		// 비밀번호 해시 생성
//    		String rawPassword =memberVO.getMemberPwd(); // 테스트용 비밀번호
//    		String hashedPassword = passwordEncoder.encode(rawPassword);
//    		System.out.println("Hashed Password: " + hashedPassword);
    		if(passwordEncoder.matches(memberVO.getMemberPwd(), resultVO.getMemberPwd())) {
    			// 로그인 성공 시 필요한 정보만 세션에 저장
                session.setAttribute("memberIdx", resultVO.getMemberIdx()); // 회원 고유 번호 저장
                session.setAttribute("memberEmail", resultVO.getMemberEmail()); // 회원 이메일 저장
                // 세션 유효 시간 설정 (30분 = 1800초)
                session.setMaxInactiveInterval(1800);
                
                return "redirect:/"; // 메인 페이지로 리다이렉트
    		}
    	}
    	model.addAttribute("url", url);
    	model.addAttribute("msg", msg);
    	return "/common/message";
    }
    
    /* 로그아웃 처리 */
    @GetMapping("/member/logout.do")
    public String logout(HttpSession session, HttpServletResponse response) {
        // 세션 무효화
        if (session != null) {
        	session.setAttribute("memberIdx", null); // 회원 고유 번호 저장
            session.setAttribute("memberEmail", null); // 회원 이메일 저장
            session.invalidate();
        }
        return "redirect:/"; // 메인 페이지로 리다이렉트
    }

    /* 회원가입 페이지 이동 */
    @GetMapping("/member/register.do")
    public String memberRegister() throws Exception {
    	logger.info("회원가입 페이지 이동");
        return "/member/register";
    }
    
    /* 회원가입 처리*/
    @PostMapping("/member/regist.do")
    public String memberRegist(@ModelAttribute("memberVO") MemberVO memberVO, Model model) throws Exception {
    	String url = "/member/register.do", msg = "회원가입 중 문제가 발생했습니다. 고객센터(1544-1234)로 문의해 주세요.";
    	
    	// 비밀번호 암호화 후 VO에 비밀번호 세팅
    	memberVO.setMemberPwd(passwordEncoder.encode(memberVO.getMemberPwd()));
    	
    	int cnt = memberService.insertMember(memberVO);
    	if(cnt == 1) { // 등록 처리 완료
    		url = "/member/login.do";
    		msg = "회원가입이 완료되었습니다!";
    	}
    	
    	model.addAttribute("url", url);
    	model.addAttribute("msg", msg);
    	return "/common/message";
    }

}
