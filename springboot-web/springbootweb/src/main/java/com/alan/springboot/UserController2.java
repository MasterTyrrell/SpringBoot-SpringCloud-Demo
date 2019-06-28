package com.alan.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//相当于所有方法都加上了@ResponseBody
@RestController
public class UserController2 {
	
	@RequestMapping(value="/user2/home.do",method=RequestMethod.GET)
	public String home1(){
		return "user home";
	}
	
}
