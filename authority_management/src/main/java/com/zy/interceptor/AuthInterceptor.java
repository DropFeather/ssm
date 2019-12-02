package com.zy.interceptor;

import com.zy.model.AuthUser;
import com.zy.util.AuthUserFunctionModel;
import com.zy.util.StringUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 实现用户登录访问的控制
 * 1.如果用户没有登录，要去访问后台界面，则拦截用户的请求
 * 2.如果用户登录，且session里面记录了用户的信息，则放权
 * @author caleb
 *
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 1.返回true，则不拦截
	 * 2.返回false，则拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 获取session对象
		HttpSession session = request.getSession();

		// 得到存储在session对象里面的用户信息 + 权限信息
		AuthUserFunctionModel model = (AuthUserFunctionModel) session.getAttribute("authUserFunctionModel");

		// 判断model是否为null
		// 代表没有权限 + 用户信息，则需要重新登录
		if(model == null) {
			response.sendRedirect("/index.html");
			return false;
		}

		// 取用户信息 aUser
		AuthUser aUser = model.getAuthUser();
		if(aUser == null) {
			response.sendRedirect("/index.html");
			return false;
		}
		List<Map<String,Object>> authFunction = model.getAuthFunction();

		// 获取用户的请求地址（接口地址）
		String requestURI = request.getRequestURI();
		requestURI = requestURI.substring("/".length()-1);
		System.out.println("url:"+requestURI);
		boolean access = false;
		for(Map<String,Object> map : authFunction) {
		    if (StringUtil.isNotEmpty(map.get("url"))){
		       if (StringUtil.containerString(requestURI,map.get("url").toString())){
		       	System.out.println(map.get("url"));
		           access=true;
		           break;
               }
            }
		}
		if(!access) {
			request.getRequestDispatcher("/WEB-INF/admin/error.html").forward(request, response);
			return access;
		}

		return access;
	}

}
