package com.note.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.note.dao.SettingMapper;
import com.note.model.Setting;
import com.note.service.ISetting;
@Service
public class SettingImpl implements ISetting {
	@Autowired
	private SettingMapper settingmapper; 
	
	@Override
	public List<Setting> getObjectList() {
		return settingmapper.getObjectList();
	}

	@Override
	public Setting getObject(int id) {
		return settingmapper.getObject(id);
	}

}
