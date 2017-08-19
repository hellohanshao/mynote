package com.note.timer;

import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.note.crawler.CrawlerPageProcess;
import com.note.dao.TaskMapper;
import com.note.model.Task;
import com.note.util.SpringBeanFactoryUtils;

/**
 * 
 * @author HS
 * 2017年7月30日 下午3:19:50
 * 任务执行类
 */
public class TimerJob implements  Job {

	private Logger log = Logger.getLogger(TimerJob.class);
	
	private static TaskMapper taskMapper;
	private  List<Task> list = getTaskAll();
	
	List<Task> getTaskAll(){
		if(taskMapper==null){
			taskMapper = SpringBeanFactoryUtils.getObject(TaskMapper.class);
		}
		try {
			list = taskMapper.getTaskAll();
		} catch (Exception e) {
			e.printStackTrace();
	}
	return list;
}
	
	public TimerJob() {
		super();
	}
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.info("开始执行作业》》》》》》》》》》》》》》");
		if(list!=null){
			try {
				for(int i=0;i<list.size();i++){
					CrawlerPageProcess c = new CrawlerPageProcess((Task)list.get(i));
					c.load();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}   
}
