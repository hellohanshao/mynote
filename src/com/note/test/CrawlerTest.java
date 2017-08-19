package com.note.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.note.crawler.CrawlerPageProcess;
import com.note.model.Task;
import com.note.service.IData;
import com.note.service.ITask;
import com.note.timer.TimerJob;
import com.note.timer.TimerJobGroup;
import com.note.util.SpringBeanFactoryUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class CrawlerTest {

	@Autowired
	private IData idata;
	@Autowired
	private ITask itask;
 	public static String JOB_NAME = "动态任务调度";  
    public static String TRIGGER_NAME = "动态任务触发器";  
    public static String JOB_GROUP_NAME = "XLXXCC_JOB_GROUP";  
    public static String TRIGGER_GROUP_NAME = "XLXXCC_JOB_GROUP"; 
	
	@Test
	public void test1 () throws Exception{
		SpringBeanFactoryUtils.getObject(IData.class).getOne(2);
	}
	
}
