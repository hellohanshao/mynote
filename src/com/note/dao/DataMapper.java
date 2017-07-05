package com.note.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.note.model.Title;
import com.note.model.crawler.Data;

/**
 * 
 * 日期：2017年7月1日
 * 作者：李小波
 * 用于主标题的增删改查
 */
public interface DataMapper {
	
	/*
	 * 获取所有有效的标题列表
	 */
	public List<Data> getAll();
	
	//根据标题di获取一条
	public Data getOne(int id);
	
	//插入一条标题信息
	public void insertOne(Data Data);
	
	//删除一条标题信息
	public void deleteOne(int id);
}
