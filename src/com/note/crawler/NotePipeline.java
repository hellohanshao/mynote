package com.note.crawler;

import java.sql.Timestamp;
import java.util.Map;

import org.apache.log4j.Logger;
import com.note.constant.TaskAndDataConstant;
import com.note.model.crawler.Data;
import com.note.service.IData;
import com.note.util.SpringBeanFactoryUtils;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.pipeline.Pipeline;
/**
 * 
 * @author HS
 * 2017年7月31日 上午10:13:38
 * 自定义pipeline 保存对象
 * 因为多线程，所以要考虑多线程情况
 */
public class NotePipeline implements Pipeline {
	
	private Logger log = Logger.getLogger(NotePipeline.class);

	private IData idata ;
	
	public NotePipeline() {
		super();
		if(idata==null){
    		idata =(IData) SpringBeanFactoryUtils.getBean(IData.class);
    	}
	}
	
	@Override
	public void process(ResultItems resultItems, us.codecraft.webmagic.Task task) {
		log.info("\n>>>>>>>>>>开始保存作业");
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
        	Data d = new Data();
        	d.setRelation("1");
        	d.setSavetime(new Timestamp(System.currentTimeMillis()));
        	d.setStatus("1");
        	d.setType("1");
        	
        	String key = entry.getKey();
        	String value =(String) entry.getValue();
        	
        	if(key.equals(TaskAndDataConstant.DATA_URL)){
        		d.setUrl(value.substring(0, getKeylength(key,value)));
        	}else if(key.equals(TaskAndDataConstant.DATA_NAME)){
        		d.setName(value.substring(0, getKeylength(key,value)));
        	}else if(key.equals(TaskAndDataConstant.DATA_PAGE)){
        		d.setPage(value.substring(0, getKeylength(key,value)));
        	}else{
        		continue;
        	}
        	
            if(d!=null && idata!=null){
            	
            	idata.insertOne(d);
            	log.info("\n保存完成>>>>>>>>>>>");
            }
        }
		
	}
	
	
	public int getKeylength(String key,String value){
		int length = value.length();
		if(key.equals(TaskAndDataConstant.DATA_URL)){
			if(length<=100){
				return length;
			}
			return 100;
			
    	}else if(key.equals(TaskAndDataConstant.DATA_NAME)){
    		if(length<=100){
				return length;
			}
			return 100;
			
    	}else if(key.equals(TaskAndDataConstant.DATA_PAGE)){
    		if(length<=4000){
				return length;
			}
			return 2000;
			
    	}
		return 100;
	}

}
