package edu.hfut.Controller.face.Login;
/*
    Project: FACE
    Author: Boyn
    Date: 2019/5/22
*/

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 注册功能的拦截器  只有preHandle()方法的重载
 */
public class FaceLoginInterceptor implements HandlerInterceptor {
	/**
	 * 这个方法是验证是否已经登陆的
	 * 通过检查浏览器所带的cookie,来确认登陆状态
	 * 如果没有登陆,则跳转到登陆界面
	 */
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
		Cookie[] cookies = httpServletRequest.getCookies();//获取页面中已有的cookies
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				String cookieName = cookie.getName();
				if (cookieName.equals("face_cookies")) {
					/*TODO:验证服务器中cookie是否一致 这一步以后会在服务器中存储cookie,防止恶意cookie注入 这个版本中先默认返回true*/
					return true;
				}
			}
		}
		httpServletRequest.getRequestDispatcher("/login").forward(httpServletRequest, httpServletResponse);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

	}
}
