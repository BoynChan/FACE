package edu.hfut.Controller.face.SignTable;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/26
*/

import edu.hfut.pojo.WorkerInfo;
import edu.hfut.service.SignTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <b>签到api的控制器</b><br>
 * 已经实现的api有:<br>
 * 1. : ../api/sign/{id} 在路径中指定worker的Id,并使该worker进行签到<br>
 * 2. : ../api/sign/list 列出当天签到的名单<br>
 * 3. : ../api/sign/list/{id} 列出该id对应worker的所有签到信息
 * 4. : ../api/sign/search 实现查找功能
 */
@Controller
@RequestMapping("/api")
public class SignController {
	@Autowired
	private SignTableService signTableService;

	/**
	 * 根据传入的id进行签到
	 * @param id id
	 * @return 成功插入的行数
	 */
	@RequestMapping("/sign/{id}")
	@ResponseBody
	public String sign(@PathVariable int id){
		int line = signTableService.insertSign(id);
		return ""+line;
	}

	/**
	 * 获取当天签到名单
	 * @return 见API文档
	 */
	@RequestMapping("/sign/list")
	@ResponseBody
	public Object signList(){
		return signTableService.selectToday();
	}

	/**
	 * 获取用户的所有签到信息
	 * @param id id
	 * @return 见API文档
	 */
	@RequestMapping("/sign/list/{id}")
	@ResponseBody
	public Object signList(@PathVariable Integer id){
		return signTableService.selectWorkerTotal(id);
	}

	/**
	 * 搜索功能实现
	 * @param workerInfo worker信息
	 * @return 见API文档
	 */
	@RequestMapping("/sign/search")
	@ResponseBody
	public Object signSearch(@RequestBody WorkerInfo workerInfo){
		return signTableService.selectByWorkerInfo(workerInfo);
	}
}
