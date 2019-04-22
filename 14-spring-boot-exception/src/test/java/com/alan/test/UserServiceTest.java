package com.alan.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alan.App;
import com.alan.service.UserServiceImpl;
/*
 * @RunWith 启动器
 */
@RunWith(SpringJUnit4ClassRunner.class)
/*
 *  1.当前为SpringBoot的测试类
 * 2.加载SpringBoot的启动类，启动springboot
 */
@SpringBootTest(classes= {App.class})
/*
 * junit和Spring整合 @Contextconfiguration("class:applicationContext.xml")
 */
public class UserServiceTest {
	@Autowired
	UserServiceImpl userServiceImpl;
	@Test
	public void testAddUser() {
		userServiceImpl.addUser();
	}
}
