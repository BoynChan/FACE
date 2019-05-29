package edu.hfut.mapper;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/26
*/

import edu.hfut.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
	/**
	 * 根据传入的用户名获取密码
	 * @param name 用户名
	 * @return 密码
	 */
	String getPassword(String name);
}
