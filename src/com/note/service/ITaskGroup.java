package com.note.service;

import java.util.List;

import com.note.exception.NoteException;
import com.note.model.TaskGroup;

/**
 * 
 * 日期：2017年7月15日 作者：李小波
 * 
 */

public interface ITaskGroup {

	public TaskGroup getTaskGroup(TaskGroup taskgroup) throws NoteException;

	public void addTaskGroup(TaskGroup taskGroup) throws NoteException;

	public void deleteTaskGroup(TaskGroup taskGroup) throws NoteException;
	
	public List<TaskGroup> getTaskGroupAll() throws NoteException;

}
