package edu.hfut.Controller.face.Login;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/26
*/

import edu.hfut.pojo.User;
import edu.hfut.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 登陆界面的Controller
 * Get方法返回login界面
 * Post方法接收登陆时POST的参数,对其进行验证
 */
@Controller("faceLogin")
public class FaceLoginController {
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("username") String username,
	                    @RequestParam("password") String password,
	                    HttpServletResponse response,
	                    Model model){
		System.out.println(password);
		User user = new User();
		user.setPassword(password);
		user.setUserName(username);
		//TODO:用户名以及密码的加密传输
		if(userService.comparePassword(user)){
			Cookie cookie = new Cookie("face_cookies", RandomStringUtils.randomAlphanumeric(8));//创建新cookie,随机生成8位
			cookie.setPath("/");//设定cookie的有效路径为全网页
			cookie.setMaxAge(60 * 60 * 24);//设定cookie的有效时间为1天
			response.addCookie(cookie);//在响应头中加上Cookie
			//TODO:Cookie的双端(服务器,客户端)验证,先行思想是保存cookie到服务器,并与客户端传过来的cookie进行对比
			return "redirect:/face";
		}else {
			//TODO:设置错误码:如密码错误 登录名错误
			model.addAttribute("success", 0);//TODO:更改成JSON格式传输以减少对JSP的依赖性
		}
		return "/login";
	}

}
