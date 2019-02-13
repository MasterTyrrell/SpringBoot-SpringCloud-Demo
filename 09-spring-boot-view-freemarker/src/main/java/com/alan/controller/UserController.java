package com.alan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alan.pojo.User;

@Controller
public class UserController {
	@RequestMapping(value="/showUser")
	public String showUser(Model model){
		List<User> list= new ArrayList<>(); 
		list.add(new User(1,"张三",22));
		list.add(new User(2,"李四",23));
		list.add(new User(3,"王二",24));
		model.addAttribute("list", list);
		System.out.println(1);
		return "userList";
	}
}
