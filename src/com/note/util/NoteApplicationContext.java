package com.note.util;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 
 * 日期：2017年6月30日
 * 作者：李小波
 * TODO获取note应用的上下文
 */
public class NoteApplicationContext {

	public static  ApplicationContext context=null;
	
	public static ApplicationContext getWebApplicationContext(ServletContext src) {
		context = WebApplicationContextUtils.getWebApplicationContext(src);
		if (context!=null) {
			return context;
		}
		return null;
	}
	
}
