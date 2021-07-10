//package com.devcdper.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import com.devcdper.interceptor.PlanInterceptor;
//
//@Configuration
//public class PlanConfig implements WebMvcConfigurer{
//	
//	private final PlanInterceptor planInterceptor;
//	
//	public PlanConfig(PlanInterceptor planInterceptor) {
//		this.planInterceptor = planInterceptor;
//	}
//	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(planInterceptor)
//				.addPathPatterns("/**")
//				.excludePathPatterns("/AdminLTE3/**")
//				.excludePathPatterns("/js/**");
//		
//		WebMvcConfigurer.super.addInterceptors(registry);
//	}
//}
