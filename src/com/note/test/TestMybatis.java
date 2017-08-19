package com.note.test;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.note.crawler.CrawlerPageProcess;
import com.note.crawler.NotePipeline;
import com.note.service.ITask;

import us.codecraft.webmagic.Spider;

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
	 	private ITask itask;  
		@Resource
		public JdbcTemplate jdbcTemplate; 
	 	

    @Test
	public void testName() throws Exception {
    	new CrawlerPageProcess().load();
	}
}
