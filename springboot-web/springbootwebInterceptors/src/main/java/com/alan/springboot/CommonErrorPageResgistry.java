package com.alan.springboot;

import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ErrorPageRegistrar;
import org.springframework.boot.web.servlet.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
@Component
public class CommonErrorPageResgistry implements ErrorPageRegistrar {

	

	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
		ErrorPage error = new ErrorPage(HttpStatus.NOT_FOUND,"/404.html");
		ErrorPage error2 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/500.html");
		registry.addErrorPages(error,error2);
	}

}
