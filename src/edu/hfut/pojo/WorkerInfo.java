package edu.hfut.pojo;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/18
*/

import java.io.Serializable;

/**
 * 工作人员信息表
 * 其中包含工作人员的id,姓名,照片(以路径方式存储),工作组,职位,年龄,脸部特征
 * id是自增的,每个工作人员注册后都会有一个id
 * 姓名(just name)
 * 照片路径: 以绝对路径进行存储
 * 照片名字: 以workerName+id的形式进行存储
 * 工作组: 示例(管理组,安全保障组...)
 * 职位: 示例(经理,员工,安全员...)
 * 年龄:整数表示
 * 脸部特征(在接口中返回的数值是byte数组,为方便存入数据库中转为String类型)
 */
public class WorkerInfo implements Serializable {
	private Integer id;
	private String workerName;
	private String phone;
	private String email;
	private String gender;
	private String photoPath;
	private String photoName;
	private String workerGroup;
	private String workerPosition;
	private String age;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getWorkerGroup() {
		return workerGroup;
	}

	public void setWorkerGroup(String workerGroup) {
		this.workerGroup = workerGroup;
	}

	public String getWorkerPosition() {
		return workerPosition;
	}

	public void setWorkerPosition(String workerPosition) {
		this.workerPosition = workerPosition;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return workerName +" : "+
				phone +" : "+
				email +" : "+
				gender +" : "+
				photoName +" : "+
				photoPath +" : "+
				workerGroup +" : "+
				workerPosition +" : "+
				age;
	}
}
