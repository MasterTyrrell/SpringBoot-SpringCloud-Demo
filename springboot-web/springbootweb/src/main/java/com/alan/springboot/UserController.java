package com.alan.springboot;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@RequestMapping(value="/user/home.do",method=RequestMethod.GET)
	@ResponseBody
	public String home1(){
		return "user home";
	}
	
	@ResponseBody
	@GetMapping("/user/home2.do")
	public String home2(){
		return "user home";
	}
	
	@ResponseBody
	@PostMapping("/user/home3.do")
	public String home3(){
		return "user home";
	}
	@ResponseBody
	@PostMapping("/user/home4.do")
	public String home4(@RequestParam(value="userName",defaultValue="admin")String userName,@RequestParam(value="userName",defaultValue="123")String pwd){
		return "user home";
	}
	@ResponseBody
	@PostMapping("/user/{id}")
	public String home5(@PathVariable("id")String id){
		return "user home";
	}
	
	@ResponseBody
	@PostMapping("/user/ip")
	public String home6(HttpServletRequest req){
		//ip
		return "user home"+req.getRemoteHost();
	}
}
