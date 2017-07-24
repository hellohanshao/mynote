package com.note.mq;

import javax.jms.*;  
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;  
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;  
@Component  
public class ProducerServiceImpl implements ProducerService {
	
	private Logger logger = Logger.getLogger(ProducerServiceImpl.class);
	
	private JmsTemplate jmsTemplate;  
    /** 
     * @Param destination: 可以使用mq自带queue，并构造注入一个name 
     * 2.可以自定义destination,生产者初始化时指定该值，消息者在消费时从该destination上取到消息 
     */  
    private String destination;  
  
    //destination入参  
    public void sendMessage(Destination destination, final String message) {
    	logger.info(destination+"生产者："+message);
        jmsTemplate.send(destination, new MessageCreator() {  
            public Message createMessage(Session session) throws JMSException {  
                return session.createTextMessage(message);  
            }  
        });  
    }  
    //destination不入参  
    public void sendMessage(final String message) {  
    	logger.info("生产者："+message);
        jmsTemplate.send(destination, new MessageCreator() {  
            @Override  
            public Message createMessage(Session session) throws JMSException {  
                return session.createTextMessage(message);  
            }  
        });  
    }  
  
    public JmsTemplate getJmsTemplate() {  
        return jmsTemplate;  
    }  
  
    @Resource  
    public void setJmsTemplate(JmsTemplate jmsTemplate) {  
        this.jmsTemplate = jmsTemplate;  
    }  
  
    public String getDestination() {  
        return destination;  
    }  
  
    public void setDestination(String destination) {  
        this.destination = destination;  
    }

}
