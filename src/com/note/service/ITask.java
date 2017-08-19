package com.note.service;

import java.util.List;

import com.note.model.Task;
import com.note.model.UserInfo;

/**
 * 
 * 日期：2017年7月15日
 * 作者：李小波
 * 
 */

public interface ITask {

	public void addTask(Task  task) throws Exception;
	
	public Task getTask(int id) throws Exception;
	
	public List<Task> getTaskAll() throws Exception;
}
