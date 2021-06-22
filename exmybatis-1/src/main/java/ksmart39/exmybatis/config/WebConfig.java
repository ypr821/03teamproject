package ksmart39.exmybatis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ksmart39.exmybatis.interceptor.CommonInterceptor;
import ksmart39.exmybatis.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	private final CommonInterceptor commonInterceptor;
	private final LoginInterceptor loginInterceptor;
	
	
	public WebConfig( CommonInterceptor commonInterceptor,LoginInterceptor loginInterceptor) {
		this.commonInterceptor = commonInterceptor;
		this.loginInterceptor = loginInterceptor;
	}
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(commonInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/favicon.ico")
				.excludePathPatterns("/js/**");

	
		registry.addInterceptor(loginInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/")
				.excludePathPatterns("/addMember")
				.excludePathPatterns("/memberIdCheck")
				.excludePathPatterns("/favicon.ico")
				.excludePathPatterns("/login")
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/js/**");
				
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	
}
