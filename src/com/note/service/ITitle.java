package com.note.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.note.model.Title;

public interface ITitle {

	//获取有效的所有标题
	public List<Title> getTitleList();
	
	//根据主键获取一条信息,初始化主页默认加载标题列表,无论是不是默认加载
	public Title getTitle(int id);
	
	//插入一条标题信息
	public void insertTitleOne(Title title);
	
	//修改一条标题信息
	public void updateTitleOne(int id,Title title);
	
	//删除一条标题信息
	public void deleteTitleOne(int id);
	
	//删除一条标题信息
	public void deleteTitleOneReal(int id);
}
