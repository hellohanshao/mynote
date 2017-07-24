package com.note.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.note.dao.TitleMapper;
import com.note.model.Title;
import com.note.mq.ProducerService;
import com.note.service.ITitle;
import com.note.util.BaseLogger;
import com.note.util.OperatorLog;
/**
 * 
 * 日期：2017年7月1日
 * 作者：李小波
 * TODO实现标题所有的增删改查
 */
@Service
public class TitleImpl extends BaseLogger implements ITitle {
	
	@Autowired
	private TitleMapper title;
	@Autowired
	private ProducerService producerService;
	@Override
	public List<Title> getTitleList() {
		OperatorLog.operator("获取所有标题信息", producerService);
		getLogger().info("获取所有标题信息");
		return title.getTitleList();
	}
	@Override
	public Title getTitle(int id) {
		getLogger().info("获取id:["+id+"]");
		OperatorLog.operator("获取id:["+id+"]", producerService);
		return title.getTitle(id);
	}
	@Override
	public void insertTitleOne(Title title) {
		getLogger().info("插入title:["+title+"]");
		this.title.insertTitleOne(title);		
	}
	@Override
	public void updateTitleOne(int id,Title title) {
		getLogger().info("更新id:["+id+"][title:]["+title+"]");	
		this.title.updateTitleOne(id, title);
	}
	@Override
	public void deleteTitleOne(int id) {
		getLogger().info("删除id:["+id+"]");	
		title.deleteTitleOne(id);
	}
	@Override
	public void deleteTitleOneReal(int id) {
		getLogger().info("彻底删除id:["+id+"]");
		title.deleteTitleOneReal(id);
	}
	
}
