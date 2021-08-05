package com.devcdper.interceptor;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class LoginInterceptor implements HandlerInterceptor{
	private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@SuppressWarnings({ "unlikely-arg-type", "unused" })
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String sessionEmail    = (String)session.getAttribute("UEMAIL");
		@SuppressWarnings("unchecked")
		List<String> sessionURI   = (List<String>)session.getAttribute("SURI");
		//요청받은 uri
		String requestUri   = request.getRequestURI();
		
		  log.info("LoginInterceptor****************************START");
		  log.info("sessionEmail				:::: {}",sessionEmail);
		  log.info("requestUri				:::: {}",sessionEmail);
		  log.info("sessionURI			:::: {}",sessionURI);

		if(sessionEmail == null) {
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인이 필요한 페이지입니다.'); location.href='/login';</script>");
			out.flush();
			return false;
		}
		if(sessionEmail == null && sessionURI.equals("/myChallenge")) {
			response.sendRedirect("/login");
			return false;
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("LoginInterceptor****************************END");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
