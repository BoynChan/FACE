package edu.hfut.mapper;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/18
*/

import com.arcsoft.face.FaceFeature;
import com.mysql.cj.jdbc.Blob;
import edu.hfut.pojo.WorkerInfo;
import javafx.concurrent.Worker;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface WorkTableMapper {
	/**
	 * 根据id来获取WorkerInfo
	 *
	 * @param id id
	 * @return WorkerInfo对象
	 */
	WorkerInfo getWorkerInfoById(Integer id);

	/**
	 * 根据姓名获取WorkerInfo
	 * @param workerName 姓名
	 * @return WorkerInfo对象
	 */
	WorkerInfo getWorkerInfoByName(String workerName);

	/**
	 * 根据手机号模糊查找WorkerInfo
	 * @param phone 手机号码
	 * @return WorkerInfo的List
	 */
	List<WorkerInfo> getWorkerListByPhone(String phone);


	/**
	 * 根据workName模糊查找WorkerInfo
	 *
	 * @param workerInfo 工作人员对象
	 * @return WorkerInfo的List
	 */
	List<WorkerInfo> getWorkerListBySearch(WorkerInfo workerInfo);

	/**
	 * 获取WorkerInfo的列表,默认为30个一组,通过offset参数设置偏移量实现分页功能
	 *
	 * @param offset 偏移量
	 * @return WorkerInfo的List
	 */
	List<WorkerInfo> getWorkerList(Integer offset);


	/**
	 * 获取全部列表
	 *
	 * @return WorkerInfo的List
	 */
	List<WorkerInfo> getAllWorkerList();


	/**
	 * 传入workerInfo对现有的数据进行更新
	 *
	 * @param workerInfo 新workerInfo对象
	 * @return 更新行数
	 */
	int updateWorkerInfo(WorkerInfo workerInfo);

	/**
	 * 根据id删除数据库中的workerInfo
	 *
	 * @param id id
	 * @return 删除行数
	 */
	int deleteWorkerInfo(Integer id);

	/**
	 * 插入新数据
	 *
	 * @param workerInfo workerInfo对象
	 * @return 插入行数
	 */
	int insertWorkerInfo(WorkerInfo workerInfo);

	/**
	 * 查询工作人员人数总数
	 *
	 * @return 工作人员数量
	 */
	int getTotalNumber();

	/**
	 * 数据库中最大的id,若无,返回1
	 *
	 * @return id
	 */
	Integer getCurrentId();

	/**
	 * 根据id来获取photo的绝对路径
	 *
	 * @param id id
	 * @return String类型的路径
	 */
	String getPhotoPathById(Integer id);

	/**
	 * 根据id来获取photo的名字
	 *
	 * @param id id
	 * @return String类型的名字
	 */
	String getPhotoNameById(Integer id);

	/**
	 * 根据id来获取工作人员名字
	 *
	 * @param id id
	 * @return String类型的名字
	 */
	String getWorkerNameById(Integer id);
}
