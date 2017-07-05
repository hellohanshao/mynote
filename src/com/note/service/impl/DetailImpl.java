package com.note.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.note.dao.DetailMapper;
import com.note.dao.TitleMapper;
import com.note.model.Detail;
import com.note.model.Title;
import com.note.service.IDeatil;
import com.note.util.BaseLogger;
/**
 * 
 * 日期：2017年7月1日
 * 作者：李小波
 * TODO实现标题所有的增删改查
 */
@Service
public class DetailImpl extends BaseLogger implements IDeatil {
	
	@Autowired
	private DetailMapper subtitle;
	@Override
	public List<Detail> getDetailList() {
		getLogger().info("获取所有标题信息");
		return subtitle.getDetailList();
	}
	@Override
	public Detail getDetail(int id) {
		getLogger().info("获取id:["+id+"]");
		return subtitle.getDetail(id);
	}
	@Override
	public void insertDetailOne(Detail title) {
		getLogger().info("插入title:["+title+"]");
		this.subtitle.insertDetailOne(title);		
	}
	@Override
	public void updateDetailOne(int id,Detail title) {
		getLogger().info("更新id:["+id+"][title:]["+title+"]");	
		this.subtitle.updateDetailOne(id, title);
	}
	@Override
	public void deleteDetailOne(int id) {
		getLogger().info("删除id:["+id+"]");	
		subtitle.deleteDetailOne(id);
	}
	@Override
	public void deleteDetailOneReal(int id) {
		getLogger().info("彻底删除id:["+id+"]");
		subtitle.deleteDetailOneReal(id);
	}
	@Override
	public List<Detail> getDetailByArr(int[] id) {
		
		return subtitle.getDetailByArr(id);
	}
	@Override
	public List<Detail> getDetailByMasterID(int relation) {
		return subtitle.getDetailByMasterID(relation);
	}
	
}
