package com.note.socket.web;

import org.apache.log4j.Logger;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.socket.TextMessage;  
import org.springframework.web.socket.WebSocketSession;  
import org.springframework.web.socket.handler.TextWebSocketHandler;  
 /**
  * 
  * 日期：2017年7月8日
  * 作者：李小波
  * websock文本处理类
  */

public class WebsocketEndPoint extends TextWebSocketHandler {  
  
	private Logger logger = Logger.getLogger(WebsocketEndPoint.class);
	
    @Override  
    protected void handleTextMessage(WebSocketSession session,  
            TextMessage message) throws Exception {  
        super.handleTextMessage(session, message);  
        logger.info("进入websocket处理类");
        TextMessage returnMessage = new TextMessage(message.getPayload()+" received at server");  
        session.sendMessage(returnMessage);  
    }  
}  
