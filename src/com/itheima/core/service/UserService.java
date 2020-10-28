package com.itheima.core.service;

import com.itheima.core.po.User;



/*
 *用户Service层
 */
public interface UserService {
	//通过名称和密码查询客户
	public User findUser(String username,String password);
	//注册用户
	public void registerUser(User user);

}
