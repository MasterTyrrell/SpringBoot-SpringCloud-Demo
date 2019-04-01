/**
 * 
 */ 
package com.alan.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alan.pojo.User;
import com.alan.service.UserService;

/** 
* @author 作者 yyh: 
* @version 创建时间：2019年2月19日 下午10:41:40 
* 类说明 
*/
/**
 * @author yyh
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
	
	@RequestMapping("/addUser")
	public String addUser(User user){
		userService.addUser(user);
		return "ok";
	}
	@RequestMapping("/showUser")
	public String showUser(Model model){
		List<User> userList = userService.listAllUser();
		model.addAttribute("userList", userList);
		return "showUser";
	}
	@RequestMapping("/toUpdateUser")
	public String getUserById(Integer id, Model model){
		User user = userService.getUserById(id);
		model.addAttribute("user",user);
		return "updateUser";
	}
	@RequestMapping("/editUser")
	public String editUser(User user){
		userService.update(user);
		return "ok";
	}
	@RequestMapping("/deleteUser")
	public String deleteUser(Integer id){
		userService.deleteUserById(id);
		return "ok";
	}
	
}
 