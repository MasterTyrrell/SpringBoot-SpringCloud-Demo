/**
 * 
 */ 
package com.alan.mapper;

import java.util.List;

import com.alan.pojo.User;

/** 
* @author 作者 yyh: 
* @version 创建时间：2019年2月19日 下午10:13:33 
* 类说明 
*/
/**
 * @author yyh
 *
 */
public interface UserMapper {
	void insertUser(User user);
	List<User> selectAllUsers();
	User getUserById(Integer id);
	void updateUser(User user);
	void deleteUserById(Integer id);
}
 