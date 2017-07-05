package com.note.test;


import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.note.model.crawler.Crawler;
import com.note.model.crawler.Data;
import com.note.service.ICrawler;
import com.note.service.IData;
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
	private IData tile;
	
	@Test
	public void test1() {
		List<Data> allTitle = tile.getAll();
		System.out.println(allTitle);
	}
	
	@Test
	public void getTitle() {
		Data title2 = tile.getOne(2);
		System.out.println(title2);
	}
	
	@Test
	public void insertTitleOne() {
		Data titleq = new Data();
		titleq.setContent("df");
	    tile.insertOne(titleq);
	}
}
