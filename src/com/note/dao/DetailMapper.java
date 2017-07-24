package com.note.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.note.model.Detail;
import com.note.model.SubTitle;
import com.note.model.Title;

/**
 * 
 * 日期：2017年7月1日
 * 作者：李小波
 * 用于主标题的增删改查
 */
public interface DetailMapper {
	
	/*
	 * 获取所有有效的标题列表
	 */
	public List<Detail> getDetailList(String page,String pageNUM);
	
	//根据标题di获取一条
	public Detail getDetail(int id);
	
	public List<Detail> getDetailByArr(int[] id);
	
	public List<Detail> getDetailByMasterID(int relation);
	
	public List<Detail> getDetailPage(int relation,String page,String defaultNUM);
	
	//插入一条标题信息
	public void insertDetailOne(Detail subtitle);
	
	//修改一条标题信息
	public void updateDetailOne(@Param("id") int id,@Param("detail") Detail subtitle);
	
	//删除一条标题信息
	public void deleteDetailOne(int id);
	
	//删除一条标题信息
	public void deleteDetailOneReal(int id);
}
