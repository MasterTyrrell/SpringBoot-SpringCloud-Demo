/**
 * 
 */ 
package com.alan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alan.mapper.UserMapper;
import com.alan.pojo.User;
import com.alan.service.UserService;

/** 
* @author 作者 yyh: 
* @version 创建时间：2019年2月19日 下午10:33:23 
* 类说明 
*/
/**
 * @author yyh
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	/* (non-Javadoc)
	 * @see com.alan.service.UserService#addUser(com.alan.pojo.User)
	 */
	@Override
	public void addUser(User user) {
		userMapper.insertUser(user);
	}
	@Override
	public List<User> listAllUser(){
		return userMapper.selectAllUsers();
	}
	@Override
	public User getUserById(Integer id){
		return userMapper.getUserById(id);
	}
	/* (non-Javadoc)
	 * @see com.alan.service.UserService#update(com.alan.pojo.User)
	 */
	@Override
	public void update(User user) {
		userMapper.updateUser(user);
	}
	/* (non-Javadoc)
	 * @see com.alan.service.UserService#deleteUserById(java.lang.Integer)
	 */
	@Override
	public void deleteUserById(Integer id) {
		userMapper.deleteUserById(id);
	}
	

	
	

}
 