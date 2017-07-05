package com.note.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.note.model.Title;
import com.note.model.crawler.Crawler;
import com.note.model.crawler.Data;

/**
 * 
 * 日期：2017年7月1日
 * 作者：李小波
 * 用于主标题的增删改查
 */
public interface CrawlerMapper {
	
	/*
	 * 获取所有有效的标题列表
	 */
	public List<Crawler> getAll();
	
	//根据标题di获取一条
	public Crawler getOne(int id);
	
	//插入一条标题信息
	public void insertOne(Crawler crawler);
	
	//删除一条标题信息
	public void deleteOne(int id);
}
