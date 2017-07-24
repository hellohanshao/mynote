package com.note.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.note.dao.TitleMapper;
import com.note.dao.UserInfoMapper;
import com.note.model.Title;
import com.note.model.UserInfo;
import com.note.mq.ProducerService;
import com.note.service.ITitle;
import com.note.service.IUserInfo;
import com.note.util.BaseLogger;
import com.note.util.OperatorLog;
/**
 * 
 * 日期：2017年7月1日
 * 作者：李小波
 * TODO实现标题所有的增删改查
 */
@Service
public class UserInfoImpl extends BaseLogger implements IUserInfo {

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Override
	public UserInfo getUserInfo(UserInfo userInfo) {
		return userInfoMapper.getUserInfo(userInfo);
	}
	
}
