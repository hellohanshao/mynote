package com.note.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import com.note.model.UserInfo;
import com.note.service.impl.UserInfoImpl;

/**
 * 
 * 日期：2017年7月27日
 * 作者：hanshao
 * shiro权限管理主要实现用户身份和权限的认证，所以本模块实现身份和权限
 */
public class ShiroDbRealm extends AuthorizingRealm {

 	@Autowired  
    private UserInfoImpl userService;  
 	
    public static final String SESSION_USER_KEY = "NOTE";  
	    
	 /** 
     * 授权操作 
     */  
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) { 
    	if (principals==null) {
			throw new AuthenticationException("PrincipalCollection参数为null");
		}
    	
    	UserInfo user = (UserInfo) SecurityUtils.getSubject().getSession().getAttribute(ShiroDbRealm.SESSION_USER_KEY);  
    	
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
        info.addRole(user.getRole().trim());  
        return info;  
    }  

    /** 
     * 身份验证操作 
     */  
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {  
        // 把token转换成User对象  
    	UserInfo userLogin = tokenToUser((UsernamePasswordToken) token);  
        // 验证用户是否可以登录  ,userLogin为前台用户名密码，然后去数据库查询，返回结果
    	UserInfo userInfo = userService.getUserInfo(userLogin);  
        if(userInfo == null){
        	throw new AuthenticationException("没有该用户"); // 退出  
        }  
        if (!userInfo.getPassword().equals(userLogin.getPassword())) {
			throw new AuthenticationException("密码错误");
		}
        // 获取当前用户的session  
        Session session = SecurityUtils.getSubject().getSession();  
        session.setAttribute(ShiroDbRealm.SESSION_USER_KEY, userInfo);   
        //当前 Realm 的 name  
        String realmName = this.getName();  
        //登陆的主要信息: 可以是一个实体类的对象, 但该实体类的对象一定是根据 token 的 username 查询得到的.  
        Object principal = token.getPrincipal();  
        //密码匹配器
        return new SimpleAuthenticationInfo(principal, userInfo.getPassword(), realmName);  
    }  

    //token转userInfo对象
    private UserInfo tokenToUser(UsernamePasswordToken authcToken) {  
    	UserInfo user = new UserInfo();  
        user.setUsername(authcToken.getUsername());  
        user.setPassword(String.valueOf(authcToken.getPassword()));  
        return user;  
    }  
  
    //一定要写getset方法  
    public UserInfoImpl getUserService() {  
        return userService;  
    }  
  
    public void setUserService(UserInfoImpl userService) {  
        this.userService = userService;  
    }  
}
