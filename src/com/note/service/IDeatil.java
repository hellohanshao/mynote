package com.note.service;

import java.util.List;

import org.springframework.test.util.MetaAnnotationUtils.UntypedAnnotationDescriptor;

import com.note.model.Detail;

public interface IDeatil {

	//获取有效的所有标题,
	public List<Detail> getDetailList();
	
	//根据title主键获取subtitle下的title
	public Detail getDetail(int id);
	
	//根据title主键获取subtitle下的title id表示主键id
	public List<Detail> getDetailByArr(int[] id);
	
	public List<Detail> getDetailByMasterID(int relation);
	
	//插入一条标题信息
	public void insertDetailOne(Detail title);
	
	//修改一条标题信息
	public void updateDetailOne(int id,Detail title);
	
	//删除一条标题信息
	public void deleteDetailOne(int id);
	
	//删除一条标题信息
	public void deleteDetailOneReal(int id);
}
