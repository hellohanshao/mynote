package com.note.service;

import java.util.List;


import com.note.model.crawler.Data;

/**
 * 
 * 日期：2017年7月1日
 * 作者：李小波
 */
public interface IData {
	
	public List<Data> getAll();
	
	public Data getOne(int id);
	
	public void insertOne(Data Data);
	
	public void deleteOne(int id);

}
