package edu.hfut.pojo;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/26
*/

/**
 * 用户类
 */
public class User {
	private String userName;
	private String password;

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
