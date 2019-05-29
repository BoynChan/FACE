package edu.hfut.mapper;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/22
*/

import edu.hfut.pojo.SignTable;
import edu.hfut.pojo.SignTableToday;
import edu.hfut.pojo.WorkerInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SignTodayTableMapper {
	/**
	 * 根据workerId插入
	 *
	 * @param signTable 签到信息
	 * @return 插入行数
	 */
	int insertSign(SignTable signTable);

	/**
	 * 根据workerId选择一条签到信息
	 *
	 * @param workerId 工作人员Id
	 * @return 签到表
	 */
	SignTable selectSign(int workerId);

	/**
	 * 选择当天全部签到信息
	 *
	 * @return 签到表单列表
	 */
	List<SignTableToday> selectSignList();


	/**
	 * 搜索功能的实现
	 * @param workerInfo 工作人员信息
	 * @return 根据条件获取对应的签到表单
	 */
	List<SignTableToday> selectSignListBySearch(WorkerInfo workerInfo);

	/**
	 * 统计签到信息条数
	 * @return 总条数
	 */
	Integer countSign(int workerId);
}
