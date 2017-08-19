package com.note.crawler;

import java.util.List;

import com.note.constant.TaskAndDataConstant;
import com.note.dao.TaskMapper;
import com.note.model.Task;
import com.note.util.PropertyUtil;
import com.note.util.SpringBeanFactoryUtils;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 
 * 日期：2017年7月4日 作者：李小波 TODO
 */
public class CrawlerPageProcess implements PageProcessor {

	private int retryTimes;
	private int sleepTime;
	private int timeOut;
	private int threadNum;
	private    Task task ;
	public CrawlerPageProcess() {
			super();
	}
	public CrawlerPageProcess(Task task) {
		super();
		this.task=task;
		this.retryTimes = Integer.valueOf(PropertyUtil.getProperty("RETRY_TIMES"));
		this.sleepTime = Integer.valueOf(PropertyUtil.getProperty("SLEEP_TIME"));
		this.timeOut = Integer.valueOf(PropertyUtil.getProperty("TIMEOUT"));
		this.threadNum =Integer.valueOf(PropertyUtil.getProperty("THREAD_NUM"));
	}


	public int getRetryTimes() {
		return retryTimes;
	}

	public void setRetryTimes(int retryTimes) {
		this.retryTimes = retryTimes;
	}

	public int getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
	}

	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

	public int getThreadNum() {
		return threadNum;
	}

	public void setThreadNum(int threadNum) {
		this.threadNum = threadNum;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	// 加载配置来完成
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

	@Override
	public Site getSite() {
		return site;
	}


	// 具体业务处理
	@Override
	public void process(Page page) {
		System.err.println(""+Thread.currentThread()+Thread.activeCount());
        page.putField(TaskAndDataConstant.DATA_URL, page.getUrl().regex(task.getPattern()).toString());
        page.putField(TaskAndDataConstant.DATA_NAME, page.getHtml().xpath(task.getKeyword().toString()).toString());
        page.putField(TaskAndDataConstant.DATA_PAGE, page.getHtml().xpath("//span[@class='education item']/@title").get());
        
        if (page.getResultItems().get(TaskAndDataConstant.DATA_URL)==null || page.getResultItems().get(TaskAndDataConstant.DATA_NAME)==null 
        		|| page.getResultItems().get(TaskAndDataConstant.DATA_PAGE)==null ){
        	
            page.setSkip(true);
            
        }
        page.addTargetRequests(page.getHtml().links().regex(task.getPattern().toString()).all());
        
	}

	public void load() {
		NotePipeline pipeline = new NotePipeline();
		Spider.create(this).addUrl(task.getDomain()).addPipeline(pipeline).thread(threadNum).runAsync();
	}
	
}
