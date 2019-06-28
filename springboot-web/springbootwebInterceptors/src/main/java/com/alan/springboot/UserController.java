package com.alan.springboot;

import java.io.FileNotFoundException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@ExceptionHandler(value=Exception.class)
	public String error(Exception e){
		return "found exception "+e.getMessage();
	}
	
	@GetMapping("/user/getUser.do")
	public String getUser(){
		throw new IllegalArgumentException("args is empty");	
//		return "user home";
	}
	
	@GetMapping("/user/error1.do")
	public String error1() throws FileNotFoundException{
		throw new FileNotFoundException("txt is empty");	
//		return "user home";
	}
	@GetMapping("/user/error2.do")
	public String error2() throws FileNotFoundException{
		throw new FileNotFoundException("pdf is empty");	
//		return "user home";
	}
}
