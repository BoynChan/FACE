package edu.hfut.service;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/18
*/

import com.mysql.cj.jdbc.Blob;
import edu.hfut.pojo.WorkerInfo;

import java.util.List;

public interface WorkTableService {
	WorkerInfo getWorkerInfoById(Integer id);

	List<WorkerInfo> getWorkerListBySearch(WorkerInfo workerInfo);

	public WorkerInfo getWorkerInfoByName(String workName);

	int insertWorkerInfo(WorkerInfo workerInfo);

	List<WorkerInfo> getWorkerList(Integer offset);

	List<WorkerInfo> getAllWorkerList();

	int updateWorkerInfo(WorkerInfo workerInfo);

	String getPhotoPathById(Integer id);

	String getPhotoNameById(Integer id);

	int getTotalNumber();

	int deleteWorkerInfo(Integer id);

	int getCurrentId();

	String getWorkerNameById(Integer id);
}
