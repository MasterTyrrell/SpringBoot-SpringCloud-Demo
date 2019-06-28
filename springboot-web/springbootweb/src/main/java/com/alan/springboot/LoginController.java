package com.alan.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public String login(String admin,String pwd,Model model){
		model.addAttribute("username", admin);
		if("amdin".equals(admin)&&"111111".equals(pwd)){
			return "/ok";
		}
		return "/fail";
	}
	
	@RequestMapping("/logout")
	public String logout(String admin,String pwd,Model model){
		model.addAttribute("username", admin);
		model.addAttribute("pwd", pwd);
	
		return "/logout";
	}
}
