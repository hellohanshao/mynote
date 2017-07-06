package com.note.mq;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

/**
 * 
 * 日期：2017年7月6日
 * 作者：李小波
 * 用于note系统的消息监听器
 */
public class NoteMessageListener implements MessageListener{

	private Logger logger = Logger.getLogger(NoteMessageListener.class);
	ExecutorService executorService = Executors.newSingleThreadExecutor();
	
	TextMessage tm =null;
	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			tm = (TextMessage)	message;
			executorService.submit(new Runnable() {  
				    @Override  
				    public void run() {  
				        try {
							logger.info("收到的消息为NoteMessageListener"+tm.getText());
						} catch (JMSException e1) {
							e1.printStackTrace();
						} catch (Exception e) {  
				            e.printStackTrace();  
				        }  
				    }  
			});
		}else {
			logger.info("message不是textmessage的实例");
		}
	}

}
