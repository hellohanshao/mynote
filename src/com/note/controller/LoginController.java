package com.note.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	private Logger log =Logger.getLogger(LoginController.class);


	/**
	 * 
	 * @return2017年6月30日
	 * user:lxb
	 * TODO
	 * 计算内存大小
	 */
	 public static String toMemoryInfo() {

       Runtime currRuntime = Runtime.getRuntime ();

       int nFreeMemory = ( int ) (currRuntime.freeMemory() / 1024 / 1024);

       int nTotalMemory = ( int ) (currRuntime.totalMemory() / 1024 / 1024);

       return nFreeMemory + "M/" + nTotalMemory +"M(free/total)" ;

	    }
	 
	 public static void main(String[] args) {
		 System.out.println(toMemoryInfo());
	}
	 /**
	  * 用户登出
	  * @param request
	  * @return2017年6月30日
	  * user:lxb
	  */
	@RequestMapping("/loginOut")
	public ModelAndView loginOut( HttpServletRequest request) {
		log.info("用户登出");
		return new ModelAndView("jsp/login") ;
	}
	
	/**
	 * 用户登录
	 * @param request
	 * @return2017年6月30日
	 * user:lxb
	 */
	@RequestMapping(value={"login"},method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login() {
		log.info("用户登录");
		
		return new ModelAndView("jsp/login");
	}
	
	
	
}
