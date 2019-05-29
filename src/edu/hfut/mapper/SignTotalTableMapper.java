package edu.hfut.mapper;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/22
*/

import edu.hfut.pojo.SignTable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SignTotalTableMapper {
	/**
	 * 根据workerId插入
	 *
	 * @param signTable 签到信息
	 * @return 插入行数
	 */
	int insertSign(SignTable signTable);


	/**
	 * 选择一名工作人员的前15条签到信息
	 * @param workerId 工作人员id
	 * @return 字符串列表 里面是签到信息的列表
	 */
	List<String> selectSignList(int workerId);
}
