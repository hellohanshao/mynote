package com.note.crawler;

import org.springframework.beans.factory.annotation.Autowired;

import com.note.model.crawler.Crawler;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class CrawlerTest  implements PageProcessor{

	


	private Site site = Site.me().setRetryTimes(3).setSleepTime(10).setTimeOut(10000);

	    @Override
	    public void process(Page page) {
//	    	page.addTargetRequests(page.getHtml().links().regex("http://localhost:8080/mynote/index/\\w+\\.do?\\w+=\\d+\\&\\w+=\\d+").all());
	    	System.out.println("================");//
	        page.putField("name", page.getHtml().xpath("//a/text()").all());
	        System.out.println(page.getResultItems().get("name")+"===============");
	        if(page.getResultItems().get("name")==null){
	            //skip this page 
	            page.setSkip(true);
	        }
	    }

	    @Override
	    public Site getSite() {
	        return site;
	    }

	    public static void main(String[] args) {
	    	System.err.println("--------------");
	        Spider.create(new CrawlerTest()).addUrl("http://cl.7x2.co/index.php?cateid=6").addPipeline(new ConsolePipeline()).thread(5).run();
	        System.err.println("--------------");
	    }
	    
	    
		
}
