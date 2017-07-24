package com.note.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.note.model.Detail;
import com.note.model.SubTitle;
import com.note.model.Title;
import com.note.service.ITitle;
import com.note.util.CommonUtil;
import com.note.util.PropertyUtil;

/**
 * 
 * 日期：2017年7月22日
 * 作者：hanshao
 * TODO
 */
public abstract class BaseController {

	@ModelAttribute
	 protected void addTitle(Model model){
		 List<Title> titleList = getITitle().getTitleList();
		 model.addAttribute("titleList", titleList);
	 }
	
	protected abstract ITitle getITitle();
	
}
