package com.gxz.sys.controller;

import java.sql.Timestamp;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gxz.sys.domain.User;
import com.gxz.sys.service.LoginInfoService;
import com.gxz.sys.utils.ActiverUser;
import com.gxz.sys.utils.WebUtils;
import com.gxz.sys.vo.LoginInfoVo;
import com.gxz.sys.vo.UserVo;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private LoginInfoService loginInfoService;
	
	@RequestMapping("login")
	public String login(UserVo userVo,Model model) {
		// 1,从当前线程里面得到Subject
		Subject subject = SecurityUtils.getSubject();
		// 2,构造用户名和密码
		AuthenticationToken token = new UsernamePasswordToken(userVo.getLoginname(), userVo.getPwd());
		try {
			// 6,使用subject去执行认证
			subject.login(token);
			System.out.println("登陆成功");
			ActiverUser activerUser=(ActiverUser) subject.getPrincipal();
			WebUtils.getCurrentHttpServletRequest().getSession().setAttribute("user", activerUser.getUser());
			//登录成功后添加日志记录
			LoginInfoVo loginInfo = new LoginInfoVo();
			loginInfo.setLoginname(activerUser.getUser().getName()+"-"+activerUser.getUser().getLoginname());
			loginInfo.setLoginip(WebUtils.getCurrentHttpServletRequest().getRemoteAddr());
			loginInfo.setLogintime(new Timestamp(System.currentTimeMillis()));
			loginInfoService.addLoginInfo(loginInfo);
			return "index";
		} catch (IncorrectCredentialsException e) {
			System.out.println("密码不正确");
			model.addAttribute("error", "密码不正确");
		} catch (UnknownAccountException e) {
			System.out.println("用户不存在");
			model.addAttribute("error", "用户不存在");
		}
		return "login";
	}

	
}
