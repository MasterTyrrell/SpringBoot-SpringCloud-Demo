package com.alan.exception;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class SimpleException {
	/**
	 * 该方法必须有返回值，返回值必须是SimpleMappingExceptinoResolver
	 * @return
	 */
	@Bean
	public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
		Properties properties = new Properties();
		properties.setProperty("java.lang.ArithmeticException", "error1");
		properties.setProperty("java.lang.NullPointerException","error2");
		resolver.setExceptionMappings(properties);
		return resolver;
	}

}
