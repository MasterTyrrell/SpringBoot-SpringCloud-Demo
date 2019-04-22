package com.alan.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionHandler implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		ModelAndView mv = new ModelAndView();
		if(ex instanceof ArithmeticException) {
			mv.setViewName("error");
		}else if(ex instanceof NullPointerException) {
			mv.setViewName("error1");
		}
		mv.addObject("error",ex.toString());
		return null;
	}

}
  