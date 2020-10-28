package com.itheima.core.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.core.dao.UserDao;
import com.itheima.core.po.User;
import com.itheima.core.service.UserService;
/**
 * 用户Service接口实现类
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	//注入UserDao
	@Autowired
	private UserDao userDao;
	//通过名称和密码查询学生
	@Override
	public User findUser(String username, String password) {
		User user = this.userDao.findUser(username, password);
		return user;
	}
	//注册
	@Override
	public void registerUser(User user) {
		this.userDao.registerUser(user);

	}
}
