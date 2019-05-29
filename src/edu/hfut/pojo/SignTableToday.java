package edu.hfut.pojo;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/18
*/

/**
 * 当天签到表
 */
public class SignTableToday {
	private String id;
	private String workerName;
	private String gender;
	private String age;
	private String phone;
	private String email;
	private String workerGroup;
	private String workerPosition;
	private String photoName;
	private String signTime;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public String getId() {
		return id;
	}

	public String getPhone() {
		return phone;
	}

	public String getPhotoName() {
		return photoName;
	}

	public String getSignTime() {
		return signTime;
	}

	public String getWorkerGroup() {
		return workerGroup;
	}

	public String getWorkerName() {
		return workerName;
	}

	public String getWorkerPosition() {
		return workerPosition;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public void setWorkerGroup(String workerGroup) {
		this.workerGroup = workerGroup;
	}

	public void setSignTime(String signTime) {
		this.signTime = signTime;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public void setWorkerPosition(String workerPosition) {
		this.workerPosition = workerPosition;
	}

	@Override
	public String toString() {
		return workerName+":"+signTime;
	}
}
