package com.note.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.note.util.NoteApplicationContext;


/**
 * 
 * 日期：2017年6月30日
 * 作者：李小波
 * TODO
 */
public class NoteServletListener implements ServletContextListener {
	
	public static Logger _logger=Logger.getLogger(NoteServletListener.class);
	
	public static int constant=5;
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	/*
	 * (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 * 日期：2017年6月30日
	 * 作者：李小波
	 * TODO设置全局变量
	 */
	@Override
	public void contextInitialized(ServletContextEvent servletEvent) {
		ServletContext src = servletEvent.getServletContext();
		_logger.info("初始化web上下文开始");
		NoteApplicationContext.getWebApplicationContext(src);
		_logger.info("初始化web上下文完成");
		src.getResourceAsStream("mynote");
		String aa = src.getServerInfo();
		src.setAttribute("src", src.getContextPath());
		src.setAttribute("file", src.getContextPath()+"/file");
	}

}
