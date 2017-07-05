package com.note.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.note.dao.CrawlerMapper;
import com.note.dao.DataMapper;
import com.note.model.Title;
import com.note.model.crawler.Data;
import com.note.service.ICrawler;
import com.note.service.IData;

/**
 * 
 * 日期：2017年7月4日
 * 作者：李小波
 * TODO
 */
@Service
public class DataImpl implements IData{

	@Autowired
	private DataMapper datamapper;
	
	@Override
	public List<Data> getAll() {
		return datamapper.getAll();
	}


	@Override
	public void insertOne(Data Data) {
		datamapper.insertOne(Data);		
	}

	@Override
	public void deleteOne(int id) {
		datamapper.deleteOne(id);
	}


	@Override
	public Data getOne(int id) {
		return datamapper.getOne(id);
	}


}
