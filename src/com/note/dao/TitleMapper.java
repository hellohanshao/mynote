package com.note.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.note.model.Title;

/**
 * 
 * 日期：2017年7月1日
 * 作者：李小波
 * 用于主标题的增删改查
 */
public interface TitleMapper {
	
	/*
	 * 获取所有有效的标题列表
	 */
	public List<Title> getTitleList();
	
	//根据标题di获取一条
	public Title getTitle(int id);
	
	//插入一条标题信息
	public void insertTitleOne(Title title);
	
	//修改一条标题信息
	public void updateTitleOne(@Param("id") int id,@Param("title") Title title);
	
	//删除一条标题信息
	public void deleteTitleOne(int id);
	
	//删除一条标题信息
	public void deleteTitleOneReal(int id);
}
