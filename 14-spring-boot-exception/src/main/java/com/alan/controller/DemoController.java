package com.alan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
	@RequestMapping("/show")
	public String show() {
//		int a = 15/0;	
		return "ok";
	}
	@RequestMapping("/show2")
	public String show2() {
		String a = null;
		System.out.println(a.length());
		return "ok";
	}
	
	@ExceptionHandler(value= {java.lang.ArithmeticException.class})
	public ModelAndView arithmeticExceptionHandler(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("error",e.toString());
		mv.setViewName("error1");
		return mv;
	}
}
