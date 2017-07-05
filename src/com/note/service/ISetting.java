package com.note.service;

import java.util.List;
import com.note.model.Setting;

public interface ISetting {

	public List<Setting> getObjectList();
	
	public Setting getObject(int id);
}
