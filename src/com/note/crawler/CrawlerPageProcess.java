package com.note.crawler;


import org.springframework.beans.factory.annotation.Autowired;

import com.note.model.crawler.Crawler;
import com.note.model.crawler.Data;
import com.note.service.ICrawler;
import com.note.service.IData;

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

	@Autowired
	private IData iData;
	
	private Crawler crawler;
	private Site site = Site.me().setRetryTimes(3).setSleepTime(10).setTimeOut(100);

	@Override
	public Site getSite() {
		return site;
	}

	@Override
	public void process(Page page) {
		Data data = new Data();
		//http https 
		//将获取到的页面url加入到后续队列中
		//获取需要的标题; 
		/* page.putField("name", page.getHtml().xpath(crawler.getNameregex()+"text()").get());
		 //获取所需要的内容
		 page.putField("content", page.getHtml().xpath(crawler.getContentregex()+"text()").get());*/
		 //保存整个页面
//		 page.putField("page", page);
		 
		 /*page.putField("url", page.getHtml().links().regex(crawler.getTargeturl()).get());
		 page.addTargetRequests(page.getHtml().links().regex(crawler.getTargeturl()).all());*/
		 
       /* if(page.getResultItems().get("name")==null){
            //skip this page 
//            page.setSkip(true);
        	page.putField("name","");
        	 page.setSkip(true);
        }
        if(page.getResultItems().get("content")==null){
        	page.putField("content","");
        	 page.setSkip(true);
        }
        if(page.getResultItems().get("page")==null){
        	page.putField("page","");
        	 page.setSkip(true);
        }
        if(page.getResultItems().get("url")==null){
        	page.putField("url","");
        	 page.setSkip(true);
        }*/
//        data.setPage("saaaaaaaaaaaaaaaaaaaaaaaaad");
        iData.insertOne(data);
	}

	 /**
	 * @return the crawler
	 */
	public Crawler getCrawler(Crawler crawler) {
		return crawler;
	}

	/**
	 * @param crawler the crawler to set
	 */
	public void setCrawler(Crawler crawler) {
		this.crawler = crawler;
	}
   
	public static void main(String[] args) {
    	System.err.println("--------------");
    	Crawler c  = new Crawler();
    	c.setTargeturl("http://localhost:8080/mynote/setting.do?id=\\d+");
    	c.setContentregex("/p/");
    	c.setNameregex("/a/");
        Spider.create(new CrawlerPageProcess()).addUrl("http://localhost:8080/mynote/setting.do?id=0").addPipeline(new ConsolePipeline()).thread(2).run();
        System.err.println("--------------");
    }
    
	

}
