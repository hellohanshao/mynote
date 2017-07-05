package com.note.controller;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.note.model.Detail;
import com.note.model.Setting;
import com.note.model.SubTitle;
import com.note.model.Title;
import com.note.service.IDeatil;
import com.note.service.ISetting;
import com.note.service.ISubTitle;
import com.note.service.ITitle;
/**
 * 
 * 日期：2017年7月1日
 * 作者：李小波
 * 用于主页标题、列表，详细列表展示
 */
@RequestMapping(value="setting")
@Controller
public class SettingController {
	
	@Autowired
	private ITitle ititle;
	@Autowired
	private ISetting isetting;
	
	
	/**
	 * 
	 * 日期：2017年7月2日
	 * 作者：李小波
	 * 设置页面显示 id=0表示设置主菜单
	 */
	@RequestMapping(value="", method={RequestMethod.GET,RequestMethod.POST})
	  public ModelAndView setting(@RequestParam ("id") String id) throws Exception
	  {
	    ModelAndView modelAndView = new ModelAndView("jsp/setting");
		if(null==id || id.trim().equals("") ||  id.trim().equals("0")){
			
			List<Title> titleList = this.ititle.getTitleList();
			List<Setting> subList = isetting.getObjectList();
		    modelAndView.addObject("titleList", titleList);
		    modelAndView.addObject("subList", subList);
		    modelAndView.addObject("subactive", id);
		    modelAndView.addObject("active", id);
			
		}else {
			throw new Exception("设置id应为0，非法输入");
		}
	    return modelAndView;
	  }
	
	@RequestMapping(value="user", method={RequestMethod.GET,RequestMethod.POST})
	  public ModelAndView user(@RequestParam ("subid") Integer subid) throws Exception
	  {
	   
		ModelAndView modelAndView =null;
		if(subid==null || subid==0){
			throw new Exception("传入的参数不合法,子菜单应为大于等于1的数");
		}else {
			if (subid==3) {
				 modelAndView = new ModelAndView("jsp/resource");
			}else{
				 modelAndView = new ModelAndView("jsp/setting");
			}
			List<Title> titleList = this.ititle.getTitleList();
			List<Setting> subList = isetting.getObjectList();
		    modelAndView.addObject("titleList", titleList);
		    modelAndView.addObject("subList", subList);
		    modelAndView.addObject("subactive", subid);
		    modelAndView.addObject("active", 0);
		}
		
	    return modelAndView;
	  }
	
}
