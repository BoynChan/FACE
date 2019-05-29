package edu.hfut.service.impl;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/27
*/

import edu.hfut.mapper.UserMapper;
import edu.hfut.pojo.User;
import edu.hfut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户的增删查改类
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	/**
	 * 获取User信息后返回密码是否对应
	 * @param user User对象
	 * @return 密码是否对应,对应返回true
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public boolean comparePassword(User user) {
		String password = userMapper.getPassword(user.getUserName());
		if(password.equals(user.getPassword())) return true;
		else return false;
	}
}
