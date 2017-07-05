package com.note.service;

import java.util.List;

import com.note.model.crawler.Crawler;

/**
 * 
 * 日期：2017年7月1日
 * 作者：李小波
 */
public interface ICrawler {
	
	public List<Crawler> getAll();
	
	public Crawler getOne(int id);
	
	public void insertOne(Crawler crawler);
	
	public void deleteOne(int id);

}
