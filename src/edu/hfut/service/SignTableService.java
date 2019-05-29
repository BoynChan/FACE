package edu.hfut.service;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/22
*/

import edu.hfut.pojo.SignTable;
import edu.hfut.pojo.SignTableToday;
import edu.hfut.pojo.WorkerInfo;

import java.util.List;
import java.util.Map;

public interface SignTableService {

	int insertSign(int id);


	int insertSignTotal(int id);


	Object selectToday();

	Object selectByWorkerInfo(WorkerInfo workerInfo);

	Object selectWorkerTotal(Integer id);

	int countSign(int id);
}
