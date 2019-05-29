package edu.hfut.Controller.face;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/25
*/

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 基本页面的控制器
 */
@Controller
@RequestMapping("/face")
public class PageController {

	/**
	 * @return 主页面
	 */
	@RequestMapping(value = {"/main","/",""})
	public String mainPage() {
		return "main";
	}

	/**
	 *
	 * @return 顶栏
	 */
	@RequestMapping("/top")
	public String topPage() {
		return "top";
	}

	/**
	 *
	 * @return 首页
	 */
	@RequestMapping("/index")
	public String indexPage() {
		return "index";
	}

	/**
	 *
	 * @return 左边的侧栏
	 */
	@RequestMapping("/left")
	public String leftPage() {
		return "left";
	}

	/**
	 *
	 * @return 注册页面
	 */
	@RequestMapping("/register")
	public String registerPage() {
		return "register";
	}

	/**
	 *
	 * @return 签到详情页面
	 */
	@RequestMapping("/sign")
	public String signPage() {
		return "sign";
	}

	/**
	 *
	 * @return 工作人员管理界面
	 */
	@RequestMapping("/worker")
	public String workerPage() {
		return "worker";
	}

	@Deprecated
	@RequestMapping("/info/{id}")
	public String infoPage(@PathVariable("id")Integer id, Model model) {
		model.addAttribute("id",id);
		return "info";
	}

	@Deprecated
	@RequestMapping("/change/{id}")
	public String changePage(@PathVariable("id")Integer id, Model model) {
		model.addAttribute(id);
		return "change";
	}
}
