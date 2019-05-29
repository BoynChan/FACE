package edu.hfut.Controller;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/18
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 * 对应jsp为index.jsp
 */
@Controller
public class indexController {
	/**
	 *
	 *
	 * @return 根目录的首页
	 */
	@RequestMapping("/")
	public String index() {
		return "";
	}

}
