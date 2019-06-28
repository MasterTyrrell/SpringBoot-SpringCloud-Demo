package com.alan.springboot;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootConfiguration
public class WebServerConfiguration {
//	 @Bean
	public EmbeddedServletContainerFactory createEmbeddedServletContainerCustomizer(){
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		factory.setPort(10020);
		factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));
		return factory;
	}
}
