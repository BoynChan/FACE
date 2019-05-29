package edu.hfut.pojo;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/18
*/

import java.io.Serializable;

/**
 * 签到表
 * 数据为id,工人id,时间
 * id是签到的id,可以起到计数的作用
 * workedId是在workerInfo表中的id键,在sql表中为了性能不设置为外键,选择在ORM中进行约束
 * 时间是签到时间
 * 要对某一个人的签到时间进行查看的话,就从这张表中获取一个人所有的签到信息.
 * 当天签到表和总签到表由于结构一样,所以共用一个POJO
 */
public class SignTable implements Serializable {
	private Integer workerId;
	private String signTime;

	public SignTable(Integer workerId, String time) {
		this.workerId = workerId;
		this.signTime = time;
	}

	public SignTable() {
	}

	public Integer getWorkerId() {
		return workerId;
	}

	public void setWorkerId(Integer workerId) {
		this.workerId = workerId;
	}

	public String getSignTime() {
		return signTime;
	}

	public void setSignTime(String signTime) {
		this.signTime = signTime;
	}

	@Override
	public String toString() {
		return "SignTable{" +
				"workerId=" + workerId +
				", signTime='" + signTime + '\'' +
				'}';
	}
}
