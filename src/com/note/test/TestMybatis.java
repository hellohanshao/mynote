package com.note.test;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.note.crawler.CrawlerPageProcess;
import com.note.model.Detail;
import com.note.mq.ProducerService;
import com.note.service.IData;
import com.note.service.IDeatil;
import com.note.util.OperatorLog;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

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
		private IData iData;
		@Autowired
		private IDeatil iDeatil;
		
	 	@Autowired  
	    private ProducerService producerService;  
	 	
	 	 @Test  
	     public void testSend2() {  
	 		OperatorLog.operator("123456", producerService);
	         
	     }  

    @Test
	public void testName() throws Exception {
    	Detail detail = new Detail();
    	detail.setDetail("dddd");
    	iDeatil.insertDetailOne(detail);
	}
}
