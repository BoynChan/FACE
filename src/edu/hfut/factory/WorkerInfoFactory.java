package edu.hfut.factory;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/18
*/

import edu.hfut.pojo.WorkerInfo;
//import edu.hfut.service.FaceEngineService;

import java.io.File;

/**
 * WorkerInfo的工厂类
 */
public class WorkerInfoFactory {

//	private FaceEngineService faceEngineService = FaceEngineService.getInstance();

	public WorkerInfo build(String name, String gender, String phone, String email, String group, String positon, String photoPath, String photoName, String age, File photoFile) {
		if (photoFile != null) {
//			byte[] faceFeature = faceEngineService.getFaceFeature(photoFile);
		}
		WorkerInfo workerInfo = new WorkerInfo();
		if (!phone.equals("")) {
			workerInfo.setPhone(phone);
		} else {
			workerInfo.setPhone("无");
		}
		if (!email.equals("")) {
			workerInfo.setEmail(email);
		} else {
			workerInfo.setEmail("无");
		}
		if (gender.equals("请选择性别")) {
			workerInfo.setGender("无");
		} else {
			workerInfo.setGender(gender);
		}
		if (!age.equals("")) {
			workerInfo.setAge(age);
		} else {
			workerInfo.setAge("无");
		}
		workerInfo.setPhotoName(photoName);
		workerInfo.setPhotoPath(photoPath);
		if (!group.equals("请选择就职部门")) {
			workerInfo.setWorkerGroup(group);
		} else {
			workerInfo.setWorkerGroup("无");
		}
		if (!name.equals("")) {
			workerInfo.setWorkerName(name);
		} else {
			workerInfo.setWorkerName("无");
		}
		if (!positon.equals("")) {
			workerInfo.setWorkerPosition(positon);
		} else {
			workerInfo.setWorkerPosition("无");
		}
		return workerInfo;
	}
}
