package com.note.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.note.dao.TaskGroupMapper;
import com.note.exception.NoteException;
import com.note.model.TaskGroup;
import com.note.service.ITaskGroup;
import com.note.util.SpringBeanFactoryUtils;

@Service
public class TaskGroupImpl implements ITaskGroup {

	@Resource
	public JdbcTemplate jdbcTemplate; 
	
	@Autowired
	private TaskGroupMapper taskgroupmapper;
	
	@Override
	public TaskGroup getTaskGroup(TaskGroup taskGroup) throws NoteException {
		try {
			
			return  taskgroupmapper.getTaskGroup(taskGroup);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addTaskGroup(TaskGroup taskGroup) throws NoteException {
		try {
			taskgroupmapper.addTaskGroup(taskGroup);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTaskGroup(TaskGroup taskGroup) throws NoteException {
		
	}

	
	/**
	 * 生成新的任务组编号 以G开头 5位数字
	 * 2017年8月4日 下午3:47:05 HS 
	 */
	public  String getTaskGroup(){
		if(jdbcTemplate==null){
			jdbcTemplate=(JdbcTemplate)SpringBeanFactoryUtils.getBean(JdbcTemplate.class);
		}
		String sql =" select last_number from user_sequences where sequence_name='TASK_GROUP_SEQUENCE' ";
    	Map<String, Object>  queryForRowSet = jdbcTemplate.queryForMap(sql);
    	String gid = queryForRowSet.get("LAST_NUMBER")+"";
		StringBuffer sb = new StringBuffer();
		sb.append("G");
		while((sb.length()+gid.length())<7){
			sb.append("0");
		}
		return sb.append(gid).toString();
	}

	@Override
	public List<TaskGroup> getTaskGroupAll() throws NoteException {
		try {
			return taskgroupmapper.getTaskGroupAll();
		} catch (Exception e) {
			return null;
		}
	}

}
