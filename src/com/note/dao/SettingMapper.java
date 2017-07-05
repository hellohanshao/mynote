package com.note.dao;

import java.util.List;
import com.note.model.Setting;

/**
 * 
 * 日期：2017年7月1日
 * 作者：李小波
 * 用于主标题的增删改查
 */
public interface SettingMapper {
	public List<Setting> getObjectList();
	
	public Setting getObject(int id);
	
}
