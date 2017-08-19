package com.note.dao;

import java.util.List;

import com.note.model.Task;

public interface TaskMapper {
	
	public void addTask(Task  task) throws Exception;
	
	public Task getTask(int id) throws Exception;
	
	public List<Task> getTaskAll() throws Exception;
	
	
	
}
