//package com.devcdper.interceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//@Component
//public class PlanInterceptor implements HandlerInterceptor{
//private static final Logger log = LoggerFactory.getLogger(PlanInterceptor.class);
//	
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		HandlerMethod method = (HandlerMethod) handler;
//		log.info("CommonInterceptor=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-START");
//		log.info("Acess Info =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- START");
//		log.info("PORT			::::::::			{}", request.getLocalPort());
//		log.info("serverName			::::::::			{}", request.getServerName());
//		log.info("method			::::::::			{}", request.getMethod());
//		log.info("URI				::::::::			{}", request.getRequestURI());
//		log.info("CONTROLLER			::::::::			{}", method.getBean().getClass().getSimpleName());
//		log.info("Acess Info =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- END");
//		return HandlerInterceptor.super.preHandle(request, response, handler);
//	}
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		log.info("CommonInterceptor=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-END");
//		/* 슬러시 포함 경로 */
//		String uri = request.getRequestURI();
//		
//		/* 슬러시 제거한 순수 경로 */
//		String pathName = uri.substring(1);
//		
//		if(!"".equals(pathName)) {
//			
//			/* 경로와 일치하는 클래스명 검색을 위한 문자열조합 */
//			String className = "."+ pathName;
//			modelAndView.addObject("pathName", pathName);
//			modelAndView.addObject("className", className);
//		}
//		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//	}
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		log.info("CommonInterceptor=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-AFTER");
//		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//	}
//}
