package edu.hfut.service;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/27
*/

import edu.hfut.pojo.User;

public interface UserService {
	public boolean comparePassword(User user);
}
