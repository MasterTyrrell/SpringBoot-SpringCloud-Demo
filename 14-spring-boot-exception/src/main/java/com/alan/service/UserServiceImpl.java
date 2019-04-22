package com.alan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alan.dao.UserDaoImpl;

@Service
public class UserServiceImpl {
	@Autowired
	public UserDaoImpl userDaoImpl;
	
	public void addUser() {
		userDaoImpl.addUser();
	}
}
