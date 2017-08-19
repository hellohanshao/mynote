package com.note.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.note.dao.TaskMapper;
import com.note.model.Task;
import com.note.service.ITask;
import com.note.timer.TimerJob;
import com.note.timer.TimerJobGroup;

@Service
public class TaskImpl implements ITask {

	@Autowired
	private TaskMapper taskmapper;
	
	@Override
	public void addTask(Task task) throws Exception {
		try {
			taskmapper.addTask(task);
			
			if(task.getImmediately().equals("1")){
				TimerJob timerJob  = new TimerJob();
				TimerJobGroup.addJob(1+"", null, "2", null, timerJob.getClass(), "0 0/2 * * * ?");
			}
			
		} catch (Exception e) {
			throw new Exception("插入失败");
		}
	}

	@Override
	public Task getTask(int id) throws Exception {
		
		
		return taskmapper.getTask(id);
	}

	@Override
	public List<Task> getTaskAll() throws Exception {
		return taskmapper.getTaskAll();
	}

}
