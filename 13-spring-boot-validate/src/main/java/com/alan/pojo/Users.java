package com.alan.pojo;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class Users {
	//不去除首位空格字符串非null,非空字符串
	//@NotEmptr
	//非空校验去除收尾字符串非null,非空字符串
	@NotBlank(message="用户名不能为空")
	@Length(min=2,max=6,message="最小长度为2")
	private String name;
	@NotBlank(message="密码不能为空")
	private String password;
	@Min(value=15)
	@Max(value=25)
	private Integer age;
	@Email
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Users [name=" + name + ", password=" + password + ", age=" + age + ", email=" + email + "]";
	}
	
}
