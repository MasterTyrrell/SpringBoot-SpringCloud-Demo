package com.alan.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Transactional(rollbackFor={Exception.class},noRollbackFor={Exception.class})
	public void addUser(String name,String pwd){
		System.out.println("新增对象11111111");
	}
}
