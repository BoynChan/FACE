package edu.hfut.service.impl;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/18
*/

import edu.hfut.mapper.WorkTableMapper;
import edu.hfut.pojo.WorkerInfo;
import edu.hfut.service.WorkTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * 将mapper接口封装为事务形式
 */
@Service
public class WorkTableServiceImpl implements WorkTableService {
	@Autowired
	private WorkTableMapper workTableMapper = null;

	/**
	 * 根据id来获取WorkerInfo
	 *
	 * @param id id
	 * @return WorkerInfo对象
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public WorkerInfo getWorkerInfoById(Integer id) {
		return workTableMapper.getWorkerInfoById(id);
	}

	/**
	 * 根据workName来获取WorkerInfo
	 *
	 * @param workName 工作人员姓名
	 * @return WorkerInfo对象
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public WorkerInfo getWorkerInfoByName(String workName) {
		return workTableMapper.getWorkerInfoByName(workName);
	}


	/**
	 * 插入新数据
	 *
	 * @param workerInfo workerInfo对象
	 * @return 插入行数
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public int insertWorkerInfo(WorkerInfo workerInfo) {
		return workTableMapper.insertWorkerInfo(workerInfo);
	}

	/**
	 * 获取WorkerInfo的列表,默认为30个一组,通过offset参数设置偏移量实现分页功能
	 *
	 * @param offset 偏移量
	 * @return WorkerInfo的List
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<WorkerInfo> getWorkerList(Integer offset) {
		List<WorkerInfo> workerInfoList = new LinkedList<>();
		workerInfoList = workTableMapper.getWorkerList(offset);
		return workerInfoList;
	}

	/**
	 *
	 * @param workerInfo WorkerInfo对象
	 * @return WorkerInfo的List
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<WorkerInfo> getWorkerListBySearch(WorkerInfo workerInfo){
		if(workerInfo.getWorkerName()==null) workerInfo.setWorkerName("%");
		else{
			String workerName = "%"+workerInfo.getWorkerName()+"%";
			workerInfo.setWorkerName(workerName);
		}
		if(workerInfo.getPhone()==null) workerInfo.setPhone("%");
		else{
			String phone = "%"+workerInfo.getPhone()+"%";
			workerInfo.setPhone(phone);
		}
		List<WorkerInfo> workerInfoList = workTableMapper.getWorkerListBySearch(workerInfo);
		return workerInfoList;
	}

	/**
	 * 传入workerInfo对现有的数据进行更新
	 *
	 * @param workerInfo 新workerInfo对象
	 * @return 更新行数
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public int updateWorkerInfo(WorkerInfo workerInfo) {
		return workTableMapper.updateWorkerInfo(workerInfo);
	}

	/**
	 * 查询工作人员人数总数
	 *
	 * @return 工作人员数量
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public int getTotalNumber() {
		return workTableMapper.getTotalNumber();
	}

	/**
	 * 根据id删除数据库中的workerInfo以及文件中对应的照片
	 *
	 * @param id id
	 * @return 删除行数
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public int deleteWorkerInfo(Integer id) {
		String fileName = getWorkerInfoById(id).getPhotoName();
		if(fileName.equals("none.jpg")){
			return workTableMapper.deleteWorkerInfo(id);
		}else {
			String filePath = getWorkerInfoById(id).getPhotoPath();
			File file = new File(filePath);
			file.delete();
			return workTableMapper.deleteWorkerInfo(id);
		}
	}

	/**
	 * 数据库中最大的id,若无,返回1
	 *
	 * @return id
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public int getCurrentId() {
		Integer id = workTableMapper.getCurrentId();
		System.out.println(id);
		if (id == null) return 1;
		else return id;
	}

	/**
	 * 获取全部列表
	 *
	 * @return WorkerInfo的List
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<WorkerInfo> getAllWorkerList() {
		List<WorkerInfo> workerInfoList = new LinkedList<>();
		workerInfoList = workTableMapper.getAllWorkerList();
		return workerInfoList;
	}

	/**
	 * 根据id来获取photo的绝对路径
	 *
	 * @param id id
	 * @return String类型的路径
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public String getPhotoPathById(Integer id) {
		String path = workTableMapper.getPhotoPathById(id);
		return path;
	}

	/**
	 * 根据id来获取photo的名字
	 *
	 * @param id id
	 * @return String类型的文件名
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public String getPhotoNameById(Integer id) {
		String name = workTableMapper.getPhotoNameById(id);
		return name;
	}

	/**
	 * 根据id来获取工作人员名字
	 *
	 * @param id id
	 * @return String类型的名字
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public String getWorkerNameById(Integer id) {
		return workTableMapper.getWorkerNameById(id);
	}
}
