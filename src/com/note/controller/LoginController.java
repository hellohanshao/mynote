package com.note.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.note.model.UserInfo;

@Controller
public class LoginController {

	private Logger log =Logger.getLogger(LoginController.class);

	
	@ModelAttribute
	private void  addPage(ModelAndView modelAndView) {
		modelAndView.setViewName("jsp/login");
		
	}
	 /**
	  * 用户登出
	  * @param request
	  * @return2017年6月30日
	  */
	@RequestMapping("/loginOut")
	public ModelAndView loginOut(ModelAndView modelAndView,  HttpServletRequest request) {
		log.info("用户登入");
		return modelAndView ;
	}
	
	/**
	 * 用户登录
	 * @param request
	 * @return2017年6月30日
	 */
	@RequestMapping(value={"login"},method={RequestMethod.GET})
	public ModelAndView  loginGet(ModelAndView modelAndView) {
		Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return new ModelAndView("redirect:/index");
        }
        log.info("用户登录");
		return modelAndView;
	}
	
	@RequestMapping(value={"login"},method={RequestMethod.POST})
	public ModelAndView  loginPost(UserInfo userInfo) {
		 Subject user = SecurityUtils.getSubject();
	        if (!user.isAuthenticated()) {
	            UsernamePasswordToken token = new UsernamePasswordToken("", "", true);   // 记住登录
	            try{
	                user.login(token);
	            } catch ( AuthenticationException ae) {
	                //return new ModelAndView("jsp/login").addObject("message", "密码错误");
	            }
	        } 
	        return new ModelAndView("redirect:/index.do?id=0");
		}
		
	
		/*private String loginUser(UserInfo user) {  
	        if (isRelogin(user)) return "SUCC"; // 如果已经登陆，无需重新登录  
	          
	        return shiroLogin(user); // 调用shiro的登陆验证  
		}  */
		
		/*private String shiroLogin(UserInfo user) {  
		        // 组装token，包括客户公司名称、简称、客户编号、用户名称；密码  
//			Subject subject = SecurityUtils.getSubject();
//			if (!subject.isAuthenticated()) {
				
				UsernamePasswordToken token = new UsernamePasswordToken("", "", null);   
//			}
			token.setRememberMe(true);  
			  
			// shiro登陆验证  
			try {  
			    SecurityUtils.getSubject().login(token);  
			} catch (UnknownAccountException ex) {  
			    return "用户不存在或者密码错误！";  
			} catch (IncorrectCredentialsException ex) {  
			    return "用户不存在或者密码错误！";  
			} catch (AuthenticationException ex) {  
			    return ex.getMessage(); // 自定义报错信息  
			} catch (Exception ex) {  
			    ex.printStackTrace();  
			    return "内部错误，请重试！";  
			}  
			return "SUCC";  
		}  
		  */
}
