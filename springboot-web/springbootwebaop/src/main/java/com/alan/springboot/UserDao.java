package com.alan.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Transactional(rollbackFor={Exception.class},noRollbackFor={Exception.class})
	public void addUser(){
		String sql = "INSERT INTO t_users (address,age,name)values('河南',21,'bibi')";
		jdbcTemplate.execute(sql);
	}
}
