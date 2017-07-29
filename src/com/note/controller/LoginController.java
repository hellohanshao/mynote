package com.note.controller;

import java.security.DigestException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.jcajce.provider.digest.SM3;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.note.model.UserInfo;
import com.note.util.SM3Util;

@Controller
public class LoginController {

	private Logger log =Logger.getLogger(LoginController.class);

	
	/**
	 * 用户登录
	 * @param request
	 * @return2017年6月30日
	 */
	@RequestMapping(value={"login"},method={RequestMethod.GET})
	public ModelAndView  loginGet(ModelAndView modelAndView) {
		
		Subject subject = SecurityUtils.getSubject();
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
		
		//获取当前登录用户
		 Subject user = SecurityUtils.getSubject();
		 String msg="";
		 //判断是否登录，如果未登录，则登录
	     //创建用户名/密码验证Token（Web 应用中即为前台获取的用户名/密码）
		 if (!user.isAuthenticated()) {
	            UsernamePasswordToken token;
				try {
					 //执行登录，如果登录未成功，则捕获相应的异常 // 记住登录
					token = new UsernamePasswordToken(userInfo.getUsername(),SM3Util.getStr2SM3(userInfo.getPassword()) , true);
					user.login(token);
					  return new ModelAndView("redirect:/index.do?id=0");
				} catch (DigestException e) {
					log.error(msg=e.getMessage());
				} catch ( AuthenticationException ae) {
	            	log.error(msg=ae.getMessage());
	            }
	        } 
		 return new ModelAndView("jsp/login").addObject("message", msg);
	      
		}
		
	
	
	@RequestMapping(value={"loginOut"},method={RequestMethod.GET,RequestMethod.POST})
	public String  loginOut() {
		
		Subject subject = SecurityUtils.getSubject();
		
		subject.logout();
		log.info(subject.getPrincipal()+"用户退出");
        return "/login";
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
