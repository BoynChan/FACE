package edu.hfut.Controller.face;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/25
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Error页面的控制器
 * 目前实现了404页面与500页面
 */
@Controller
@RequestMapping("/error")
public class ErrorController {
	/**
	 * 404页面
	 * @return 404页面
	 */
	@RequestMapping("/404")
	public String error404(){
		return "errorPage";
	}

	/**
	 * 返回字符串,仅显示信息
	 * @return 500页面
	 */
	@RequestMapping("/500")
	@ResponseBody
	public String error500(){
		return "服务器发生错误!如多次遇到请联系管理员";
	}
}
