package com.note.crawler;


import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.instrument.classloading.tomcat.TomcatLoadTimeWeaver;
import org.springframework.stereotype.Component;

import com.note.dao.DataMapper;
import com.note.model.crawler.Crawler;
import com.note.model.crawler.Data;
import com.note.service.ICrawler;
import com.note.service.IData;
import com.note.service.impl.DataImpl;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 
 * 日期：2017年7月4日
 * 作者：李小波
 * TODO
 */
public class CrawlerPageProcess implements PageProcessor{


    private ApplicationContext context;

    public CrawlerPageProcess() {
        context = new ClassPathXmlApplicationContext("classpath:spring.xml");
    }
	
	
	private IData iData;
	
	private Site site = Site.me().setRetryTimes(3).setSleepTime(100).setTimeOut(10000);

	
	@Override
	public Site getSite() {
		return site;
	}

	@Override
	public void process(Page page) {
    	 /* page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
          page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
          page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
          if (page.getResultItems().get("name")==null){
              page.setSkip(true);
          }
          page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));*/
          Data data = new Data();
          data.setUrl("http");
          data.setContent("content");
          data.setStatus("1");
          
          data.setSavetime(new Timestamp(System.currentTimeMillis()));
          data.setPage("q");
          data.setType("1");
          data.setRelation("1");
          data.setName("name");
          data.setId(5);
          
           iData =(IData) context.getBean("dataImpl");
           iData.insertOne(data);
	}

   
	public static void main(String[] args) {
		/*DataImpl dataImpl = new DataImpl();
		Data data = new Data();
        data.setUrl("http");
        data.setContent("content");
        data.setStatus("setStatus");
        
        data.setSavetime(new Timestamp(System.currentTimeMillis()));
        data.setPage("q");
        data.setType("1");
        data.setRelation("1");
        data.setName("name");
        data.setId(4);
        dataImpl.insertOne(data);*/
        Spider.create(new CrawlerPageProcess()).addUrl("https://github.com/code4craft").addPipeline(new ConsolePipeline()).thread(1).run();
        System.err.println("--------------");
    }
    
	

}
