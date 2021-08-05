package com.devcdper.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class Commoninterceptor  implements HandlerInterceptor{
	
	private static final Logger log = LoggerFactory.getLogger(Commoninterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		log.info("Commoninterceptor===============================================================START");
		log.info("ACCESS INFO===============================================================START");
		log.info("PORT         ::::::::::::::::::::::::  {}",request.getLocalPort());
		log.info("serverName   ::::::::::::::::::::::::  {}",request.getServerName());
		log.info("method       ::::::::::::::::::::::::  {}",request.getMethod());
		log.info("URI          ::::::::::::::::::::::::  {}",request.getRequestURI());
		log.info("ACCESS INFO===============================================================END");
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		log.info("Commoninterceptor===============================================================END");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		log.info("Commoninterceptor===============================================================AFTER");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}