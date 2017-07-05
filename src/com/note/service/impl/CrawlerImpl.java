package com.note.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.note.dao.CrawlerMapper;
import com.note.model.crawler.Crawler;
import com.note.service.ICrawler;

/**
 * 
 * 日期：2017年7月4日
 * 作者：李小波
 * TODO
 */
@Service
public class CrawlerImpl implements ICrawler{

	@Autowired
	private CrawlerMapper crawler;
	
	@Override
	public List<Crawler> getAll() {
		return crawler.getAll();
	}

	@Override
	public Crawler getOne(int id) {
		return crawler.getOne(id);
	}

	@Override
	public void deleteOne(int id) {
		crawler.deleteOne(id);
	}

	@Override
	public void insertOne(Crawler crawler) {
		this.crawler.insertOne(crawler);
	}


}
