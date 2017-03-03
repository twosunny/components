package woosun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import woosun.interceptor.CommonInterceptor;

@Configuration
public class WebInterceptorConfiguration extends WebMvcConfigurerAdapter{

	@Override
	public void addInterceptors(InterceptorRegistry registry){ 
		registry.addInterceptor(getCommonInterceptor()).addPathPatterns("/**");
	}
	
	@Bean
	public HandlerInterceptorAdapter getCommonInterceptor(){
		return new CommonInterceptor();
	}
}
