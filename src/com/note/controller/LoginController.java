package com.note.controller;

import java.security.DigestException;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpRequest;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.note.crawler.CrawlerPageProcess;
import com.note.model.UserInfo;
import com.note.util.SM3Util;

@Controller
public class LoginController {

	private Logger log =Logger.getLogger(LoginController.class);
	private static final String SESSION_USER_KEY = "NOTE"; 
	
	Subject subject ;
	/**
	 * 用户登录
	 * @param request
	 * @return2017年6月30日
	 */
	@RequestMapping(value={"login"},method={RequestMethod.GET})
	public ModelAndView  loginGet(HttpServletRequest req) {
		subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
        	log.info("用户已经登录");
            return new ModelAndView("redirect:/index.do?id=0");
        }
        return new ModelAndView("jsp/login");
	}
	
	//Credentials 证书  Principal用户名
	@RequestMapping(value={"login"},method={RequestMethod.POST})
	public ModelAndView  loginPost(@ModelAttribute("userInfo") UserInfo userInfo) {
		//登录加密、前台 后台各加密一次，保证传输和存储安全
		 subject = SecurityUtils.getSubject();
		//获取当前登录用户
		 String msg="";
		 //判断是否登录，如果未登录，则登录
	     //创建用户名/密码验证Token（Web 应用中即为前台获取的用户名/密码）
		 if (!subject.isAuthenticated()) {
	            UsernamePasswordToken token;
				try {
					 //执行登录，如果登录未成功，则捕获相应的异常 // 记住登录
					token = new UsernamePasswordToken(userInfo.getUsername(),SM3Util.getStr2SM3(userInfo.getPassword()) , true);
					subject.login(token);
					return new ModelAndView("redirect:/index.do?id=0");
				} catch (DigestException e) {
					log.error(msg=e.getMessage());
				} catch ( AuthenticationException ae) {
	            	log.error(msg=ae.getMessage());
	            }
	        } 
		 return new ModelAndView("jsp/login").addObject("message", msg);
	      
		}
		
	
	//根本问题是ajax没有往浏览器中发送cookie信息，造成下次请求还有信息
	@RequestMapping(value={"loginOut"},method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView  loginOut() {
		subject = SecurityUtils.getSubject();
		log.info(subject.getPrincipal()+"用户退出");
		subject.logout();
		return new ModelAndView("jsp/login"); 
	}
}
