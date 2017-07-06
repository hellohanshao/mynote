package com.note.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.note.mq.ProducerService;

/**
 * 
 * @author 李小波
 * 系统测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class TestMybatis {

	private static final Logger logger = Logger.getLogger(TestMybatis.class);
	
	 	@Autowired  
	    private ProducerService producerService;  
	 	
	 	 @Test  
	     public void testSend2() {  
	   
	         for (int i=0; i<10; i++) {  
	             producerService.sendMessage2( "你好，生产者！这是消息testbatis：" + (i+1));  
	         }  
	         
	     }  

    @Test
	public void testName() throws Exception {
		
	}
}
