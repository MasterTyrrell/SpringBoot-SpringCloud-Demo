package com.alan.springboot;

import java.util.Arrays;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class ServletConfiguration {
	@Bean
	public ServletRegistrationBean createServlet(){
		return new ServletRegistrationBean(new MyNewServlet());
	}
	@Bean
	public FilterRegistrationBean createFilter(){
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new MyNewFilter());
		filter.setUrlPatterns(Arrays.asList("/user.do"));
		return filter;
	}
	@Bean
	public ServletListenerRegistrationBean<MyNewListener> createListener(){
		return new ServletListenerRegistrationBean<>(new MyNewListener());
	}
}
