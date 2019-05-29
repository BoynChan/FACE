package edu.hfut.Controller.face.workerInfo;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/26
*/

import edu.hfut.pojo.WorkerInfo;
import edu.hfut.service.WorkTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.*;

/**
 * 对客户信息查找的api控制器
 */
@Controller
@RequestMapping("/api")
public class workerInfoController {
	@Autowired
	private WorkTableService workTableService;

	/**
	 * 返回目前全部worker的信息
	 * @return 见API文档
	 */
	@RequestMapping("/worker/list")
	@ResponseBody
	public Object workerList(){
		Map<String,Object> responseMap = new HashMap<>();
		List<WorkerInfo> workerInfoList;
		workerInfoList = workTableService.getAllWorkerList();
		responseMap.put("length",workerInfoList.size());
		responseMap.put("workerList",workerInfoList);
		return responseMap;
	}

	/**
	 * 返回查找信息
	 * @param workerInfo 工作人员
	 * @return 见API文档
	 */
	@RequestMapping("/worker/list/search")
	@ResponseBody
	public Object workerList(@RequestBody WorkerInfo workerInfo){
		List<WorkerInfo> workerInfoList = workTableService.getWorkerListBySearch(workerInfo);
		Map<String,Object> responseMap = new HashMap<>();
		responseMap.put("length",workerInfoList.size());
		responseMap.put("workerList",workerInfoList);
		return responseMap;
	}


	/**
	 * 根据id查找worker信息
	 * @param id id
	 * @return 见API文档
	 */
	@RequestMapping("/worker/{id}")
	@ResponseBody
	public Object workerById(@PathVariable("id")int id){
		return workTableService.getWorkerInfoById(id);
	}

	/**
	 * 根据id删除worker
	 * @param id id
	 * @return 见API文档
	 */
	@RequestMapping("/worker/delete/{id}")
	@ResponseBody
	public Object workerDelete(@PathVariable("id")int id){
		workTableService.deleteWorkerInfo(id);
		Map<String,Object> responseMap = new HashMap<>();
		responseMap.put("result","success");
		return responseMap;
	}



	/**
	 * 未开发完成,安卓端采用下载照片进行比对
	 * @param id id
	 * @return null
	 * @throws SQLException
	 */
	@Deprecated
	@RequestMapping("/worker/face/{id}")
	@ResponseBody
	public Object faceFeature(@PathVariable("id")Integer id) throws SQLException {
//		Blob faceFeature = workTableService.getFaceFeatureById(id);
//		InputStream in = faceFeature.getBinaryStream();
//		byte[] data = new byte[1023];
//		Map<String,Object> responseMap = new HashMap<>();
//		responseMap.put("faceFeature",faceFeature);
//		return responseMap;
		return null;
	}
}
