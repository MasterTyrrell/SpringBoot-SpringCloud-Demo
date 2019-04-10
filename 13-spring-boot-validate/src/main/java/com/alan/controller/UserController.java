package com.alan.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alan.pojo.Users;

@Controller
public class UserController {
		//解决异常的方式，可以跳转页面的方法中注入一个Users对象 注意：由于springmvc会将该对象
		//对象放入到Model中传递，key的名称会使用该对象的驼峰式的命名规则来作为key,参数的变量名
		//需要与对象的名称相同
		@RequestMapping("/addUser")
		public String addUser(@ModelAttribute("aa")Users users) {
			return "addUser";
		}
		
		@RequestMapping("/save")
		//@Valid开启数据校验
		//封装了校验的结果	
		public String saveUser(@ModelAttribute("aa")@Valid Users user,BindingResult result) {
			
			if(result.hasErrors()) {
				return "addUser";
				//出现不合法数据
			}
			System.out.println(user);
			return "ok";
		}
}
