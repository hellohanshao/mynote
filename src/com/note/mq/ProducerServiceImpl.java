package com.note.mq;

import javax.jms.*;  
import javax.annotation.Resource;  
  
import org.springframework.jms.core.JmsTemplate;  
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;  
@Component  
public class ProducerServiceImpl implements ProducerService {
	private JmsTemplate jmsTemplate;  
    /** 
     * @Param destination: 可以使用mq自带queue，并构造注入一个name 
     * 2.可以自定义destination,生产者初始化时指定该值，消息者在消费时从该destination上取到消息 
     */  
    private String destination;  
  
    //destination入参  
    public void sendMessage(Destination destination, final String message) {  
        System.out.println("---------------sendMessage生产者发了一个消息：" + message);  
        jmsTemplate.send(destination, new MessageCreator() {  
            public Message createMessage(Session session) throws JMSException {  
                return session.createTextMessage(message);  
            }  
        });  
    }  
    //destination不入参  
    public void sendMessage2(final String message) {  
        System.out.println("---------------sendMessage2生产者发了一个消息：" + message);  
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
	@Override
	public void sendMessage3(String a, String bString) {
		// TODO Auto-generated method stub
		
	}  

}
