package com.devcdper.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.devcdper.interceptor.Commoninterceptor;
import com.devcdper.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	private final Commoninterceptor commonInterceptor;
	private final LoginInterceptor loginInterceptor;
	
	public WebConfig(Commoninterceptor commonInterceptor, LoginInterceptor loginInterceptor) {
		this.commonInterceptor = commonInterceptor;
		this.loginInterceptor = loginInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(commonInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/")
				.excludePathPatterns("/AdminLTE3/**")
				.excludePathPatterns("/css/*")
				.excludePathPatterns("/ajax/**")
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/img/**")
				.excludePathPatterns("/lib/**")
				.excludePathPatterns("/vendor/**")
				.excludePathPatterns("/js/**");
		
		//허용되는 것만 작성
		//localhost는 인터셉터를 거치지 않게
		//css파일은 인터셉터를 거치지 않게 
		registry.addInterceptor(loginInterceptor)
		.addPathPatterns("/**")
		.excludePathPatterns("/")
		.excludePathPatterns("/AdminLTE3/**")
		.excludePathPatterns("/favicon.ico")
		.excludePathPatterns("/css/*")
		.excludePathPatterns("/ajax/**")
		.excludePathPatterns("/css/**")
		.excludePathPatterns("/img/**")
		.excludePathPatterns("/lib/**")
		.excludePathPatterns("/vendor/**")
		.excludePathPatterns("/js/**")
		.excludePathPatterns("/login")
		.excludePathPatterns("/adminEmailCheck")
		.excludePathPatterns("/coachEmailCheck")
		.excludePathPatterns("/normalEmailCheck")
		.excludePathPatterns("/fileDownload")
		
		.excludePathPatterns("/adminForgotPassword")
		.excludePathPatterns("/normalForgotPassword")
		.excludePathPatterns("/coachForgotPassword")
		
		.excludePathPatterns("/adminForgotEmail")
		.excludePathPatterns("/adminForgotPassword")
		
		.excludePathPatterns("/normalForgotEmail")
		.excludePathPatterns("/normalForgotPassword")
		
		.excludePathPatterns("/coachForgotEmail")
		.excludePathPatterns("/coachForgotPassword")
		.excludePathPatterns("/fileDownload")
		.excludePathPatterns("/")
		.excludePathPatterns("/normalLogin")
		.excludePathPatterns("/addNormal")
		.excludePathPatterns("/adminLogin")
		.excludePathPatterns("/addAdmin")
		.excludePathPatterns("/coachLogin")
		.excludePathPatterns("/addCoach")
		.excludePathPatterns("/logout")
		.excludePathPatterns("/mainChallenge")
		.excludePathPatterns("/byCategoryMain")
		.excludePathPatterns("/byCategoryExploration")
		.excludePathPatterns("/byCategory")
		.excludePathPatterns("/challengeExploration")
		.excludePathPatterns("/challengeExplorationDetailInfo");
	}
}

