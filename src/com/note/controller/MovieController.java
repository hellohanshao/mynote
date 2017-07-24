package com.note.controller;


import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.note.constant.PageConstant;
import com.note.model.Detail;
import com.note.model.SubTitle;
import com.note.model.Title;
import com.note.service.IDeatil;
import com.note.service.ISubTitle;
import com.note.service.ITitle;
import com.sun.tools.corba.se.idl.StringGen;
import com.sun.tools.internal.ws.processor.model.Request;
/**
 * 
 * 日期：2017年7月1日
 * 作者：李小波
 * 用于主页标题、列表，详细列表展示
 */
@Controller
@RequestMapping(PageConstant.MOVIE_PAGE)
public class MovieController extends BaseController{

	@Autowired
	private ITitle ititle;
	
	@Override
	protected ITitle getITitle() {
		return ititle;
	}
	
	@RequestMapping(value="",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView movie(){
		
		return  new ModelAndView(PageConstant.PAGE_PREFIX+"/"+PageConstant.MOVIE_PAGE);
	}
	
}
