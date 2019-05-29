package edu.hfut.service.impl;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/22
*/

import edu.hfut.mapper.SignTodayTableMapper;
import edu.hfut.mapper.SignTotalTableMapper;
import edu.hfut.pojo.SignTable;
import edu.hfut.pojo.SignTableToday;
import edu.hfut.pojo.WorkerInfo;
import edu.hfut.service.SignTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SignTableServiceImpl implements SignTableService {
	@Autowired
	private SignTodayTableMapper signTodayTableMapper;
	@Autowired
	private SignTotalTableMapper signTotalTableMapper;

	/**
	 * 输入id插入一条签到信息到两张签到表中
	 *
	 * @param id 工作人员id
	 * @return 插入行数
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public int insertSign(int id) {
		if (countSign(id)==0) {
			SimpleDateFormat formatPattern = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String currentTime = formatPattern.format(date);
			SignTable signTable = new SignTable(id, currentTime);
			signTotalTableMapper.insertSign(signTable);
			signTodayTableMapper.insertSign(signTable);
		}
		return 1;
	}

	/**
	 * 根据workerInfo查找签到表信息
	 * @param workerInfo workerInfo
	 * @return 返回一个包含列表长度和列表本身的map
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Object selectByWorkerInfo(WorkerInfo workerInfo) {
		if(workerInfo.getWorkerName().equals("")) workerInfo.setWorkerName("%");
		else{
			String workerName = "%"+workerInfo.getWorkerName()+"%";
			workerInfo.setWorkerName(workerName);
		}
		if(workerInfo.getPhone().equals("")) workerInfo.setPhone("%");
		else{
			String phone = "%"+workerInfo.getPhone()+"%";
			workerInfo.setPhone(phone);
		}
		Map<String,Object> responseMap = new HashMap<>();
		List<SignTableToday> list = signTodayTableMapper.selectSignListBySearch(workerInfo);
		for (SignTableToday signTableToday : list){
			if(signTableToday.getSignTime()==null){
				signTableToday.setSignTime("未签到");
			}else{
				signTableToday.setSignTime("已签到");
			}
		}
		responseMap.put("length",list.size());
		responseMap.put("workerList",list);
		return responseMap;
	}

	/**
	 * 输入id插入一条签到信息到总签到表
	 *
	 * @param id 工作人员id
	 * @return 插入行数
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public int insertSignTotal(int id) {
		Date date = new Date();
		SignTable signTable = new SignTable(id, date.toString());
		return signTotalTableMapper.insertSign(signTable);
	}

	/**
	 * 选择当天全部签到记录
	 *
	 * @return 包含当天签到记录列表长度与当天签到记录列表本身的一个map
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Object selectToday() {
		Map<String,Object> responseMap = new HashMap<>();
		List<SignTableToday> list = signTodayTableMapper.selectSignList();
		for (SignTableToday signTableToday : list){
			if(signTableToday.getSignTime()==null){
				signTableToday.setSignTime("未签到");
			}else{
				signTableToday.setSignTime("已签到");
			}
		}
		responseMap.put("length",list.size());
		responseMap.put("workerList",list);
		return responseMap;
	}

	/**
	 * 选择一个工作人员的最近15条签到记录
	 *
	 * @return 签到记录列表
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Object selectWorkerTotal(Integer id) {
		Map<String,Object> responseMap = new HashMap<>();
		List<String> list = signTotalTableMapper.selectSignList(id);
		responseMap.put("length",list.size());
		responseMap.put("signTime",list);
		return responseMap;
	}

	/**
	 * 根据传入的id统计签到次数
	 * 主要用来验证id在今天是否有签到
	 *
	 * @param id 工作人员id
	 * @return 签到次数(通常为0和1)
	 */
	@Override
	public int countSign(int id) {
		return signTodayTableMapper.countSign(id);
	}

}
