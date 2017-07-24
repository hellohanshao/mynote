package com.note.mq;

import javax.jms.Destination;


public interface ProducerService {  
    /** 
     * 使用mq默认destination 
     * @param destination 
     * @param message 
     */  
    public void sendMessage(Destination destination,final String message);  
  
    /** 
     * 自定义destination 
     * @param message 
     */  
    public void sendMessage(final String message);  
  
    
}
