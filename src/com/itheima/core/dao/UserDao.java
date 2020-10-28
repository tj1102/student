package com.itheima.core.dao;
import com.itheima.core.po.User;
import org.apache.ibatis.annotations.Param;

/**
 * 用户Dao层
 *
 */
public interface UserDao {

	//通过学生名称和密码查询学生

	public User findUser(@Param("username") String username,
						 @Param("password") String password);

	//注册学生
	public void registerUser(User user);

}
