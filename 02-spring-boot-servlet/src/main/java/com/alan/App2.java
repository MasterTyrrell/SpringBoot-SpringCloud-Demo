package com.alan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.alan.servlet.SecondServlet;

@SpringBootApplication
public class App2 {
		
	public static void main(String[] args){
		SpringApplication.run(App2.class, args);
	}
	@Bean
	public ServletRegistrationBean getServletRegisterationBean(){
		ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
		bean.addUrlMappings("/second");
		return bean;
	}
}
