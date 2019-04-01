/**
 * 
 */ 
package com.alan.service;

import java.util.List;

import com.alan.pojo.User;

/** 
* @author 作者 yyh: 
* @version 创建时间：2019年2月19日 下午10:31:32 
* 类说明 
*/
/**
 * @author yyh
 *
 */
public interface UserService {
	void addUser(User user);
	List<User> listAllUser();
	User getUserById(Integer id);
	void update(User user);
	void deleteUserById(Integer id);
}
 