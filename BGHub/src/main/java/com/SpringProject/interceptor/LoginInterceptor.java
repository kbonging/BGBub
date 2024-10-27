package com.SpringProject.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginInterceptor implements HandlerInterceptor{
	
	 	@Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	        HttpSession session = request.getSession(false);
	        System.out.println("preHandle: 호출됩니다.");
	        // 캐시 방지 설정
	        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
	        response.setHeader("Pragma", "no-cache");
	        response.setDateHeader("Expires", 0);
	        if (session == null || session.getAttribute("memberIdx") == null) {
	            response.sendRedirect(request.getContextPath() + "/member/login.do");
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	                           ModelAndView modelAndView) throws Exception {
	        // 컨트롤러의 처리 후에 추가적인 데이터를 모델에 추가하거나 로그를 남기는 등의 작업을 수행
	        System.out.println("postHandle: 컨트롤러 실행 후 호출됩니다.");
	    }

	    @Override
	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	            throws Exception {
	        // 요청 완료 후, 리소스를 해제하거나 에러 로그를 기록하는 등의 작업을 수행
	        System.out.println("afterCompletion: 요청 완료 후 호출됩니다.");
	    }
}
