package ksmart39.mybatis.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import ksmart39.mybatis.dao.MemberMapper;

@Component
public class CommonInterceptor implements HandlerInterceptor{
	
	
	private static final Logger log = LoggerFactory.getLogger(CommonInterceptor.class);

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod method = (HandlerMethod) handler;
		
		log.info("CommonInterceptor============================================START");
		log.info("Acess Info==========================================START");
		log.info("PORT			:::::::			{}", request.getLocalPort());
		log.info("ServerName	:::::::			{}", request.getServerName());
		log.info("Method		:::::::			{}", request.getMethod());
		log.info("URI			:::::::			{}", request.getRequestURI());
		log.info("Controller	:::::::			{}", method.getBean().getClass().getSimpleName());		
		log.info("Acess Info==========================================END");
	
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("CommonInterceptor============================================END");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("CommonInterceptor============================================AFTER");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
