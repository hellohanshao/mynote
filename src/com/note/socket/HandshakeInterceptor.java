package com.note.socket.web;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;  
import org.springframework.http.server.ServerHttpResponse;  
import org.springframework.web.socket.WebSocketHandler;  
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;  
 /**
  * 
  * 日期：2017年7月8日
  * 作者：李小波
  * 与服务器建立连接类
  */
public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor{  
  
		
	private Logger logger = Logger.getLogger(HandshakeInterceptor.class);
	
	/*
	 * 握手之前统计用户在线状态
	 */
    @Override  
    public boolean beforeHandshake(ServerHttpRequest request,  
            ServerHttpResponse response, WebSocketHandler wsHandler,  
            Map<String, Object> attributes) throws Exception {  
    		logger.info("用户登录");
        return super.beforeHandshake(request, response, wsHandler, attributes);  
    }  
  
    @Override  
    public void afterHandshake(ServerHttpRequest request,  
            ServerHttpResponse response, WebSocketHandler wsHandler,  
            Exception ex) {  
    		logger.info("握手之后"); 
        super.afterHandshake(request, response, wsHandler, ex);  
    }  
  
}  