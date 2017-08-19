package com.note.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.note.model.TaskGroup;

public interface TaskGroupMapper {
	
	public void addTaskGroup(TaskGroup  taskGroup) throws Exception;
	
	public TaskGroup getTaskGroup(TaskGroup taskGroup) throws Exception;
	
	public List<TaskGroup> getTaskGroupAll() throws Exception;
	
	
	
}
