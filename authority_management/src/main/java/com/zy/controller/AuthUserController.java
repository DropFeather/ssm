package com.zy.controller;

import com.zy.model.AuthUser;
import com.zy.service.AuthUserService;
import com.zy.util.AuthUserFunctionModel;
import com.zy.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/authuser")
public class AuthUserController {

	@Autowired
	private AuthUserService authUserService;

	/**
	 * 用户登录的请求
	 * 1.不成功，返回index.html
	 * 2.成功，进入到后台界面
	 * @return
	 */
	@RequestMapping("/login")
	public String login(AuthUser authUser, HttpSession session) {
		String password = new MD5().getMD5ofStr(authUser.getPassword()); // MD5的密文
		authUser.setPassword(password);
		AuthUser aUser = authUserService.getAuthUser(authUser);
		System.out.println("user"+aUser);
		if(aUser == null) {
			return "redirect:/index.html";
		}

		// 验证数据通过
		// 1.获取用户的权限信息
		// 2.把AuthUser + Function一起绑定到 权限的模型里面
		// 3.权限的模型放入到Session里面
		List<Map<String,Object>> authFunction = authUserService.getAuthUserFunction(aUser);
		AuthUserFunctionModel authUserFunctionModel = new AuthUserFunctionModel(aUser, authFunction);
		session.setAttribute("authUserFunctionModel", authUserFunctionModel);

		return "redirect:/authuser/index.do";
	}

	/**
	 * 后台管理界面的跳转（请求）
	 * @return
	 */
	@RequestMapping("/index")
	public String adminIndexPage() {
		return "index"; // 通过视图解析器去完成地址转换 /WEB-INF/admin/index.html
	}

	/**
	 * 后台的欢迎界面的跳转
	 * @return
	 */
	@RequestMapping("/welcome")
	public String adminWelcomePage() {
		return "welcome";
	}

	/**
	 * 注销
	 * @return
	 */
	@RequestMapping("/closelogin")
	public String closelogin(HttpServletRequest request) {
		request.getSession().setAttribute("authUserFunctionModel",null);
		return "redirect:../index.html";
	}
}
