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
import com.note.constant.PageConstant;
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
@RequestMapping(PageConstant.SET_PAGE)
@Controller
public class SetController extends BaseController{
	
	
	@Autowired
	private ITitle ititle;
	
	@Autowired
	private ISetting iSetting;
	
	
	@Override
	protected ITitle getITitle() {
		return ititle;
	}
	
	/*@RequestMapping(value="",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView set(){
		
		return  new ModelAndView(PageConstant.PAGE_PREFIX+PageConstant.PAGE_SEPARATOR+PageConstant.SET_PAGE);
	}*/
	
	
	
	/*@Autowired
	private ITitle ititle;
	@Autowired
	private ISetting isetting;
	
	
	*//**
	 * 
	 * 日期：2017年7月2日
	 * 作者：李小波
	 * 设置页面显示 id=0表示设置主菜单
	 */
	@RequestMapping(value="", method={RequestMethod.GET,RequestMethod.POST})
	  public ModelAndView setting(@RequestParam ("id") String id) throws Exception
	  {
			
	    return commonModelAndView(id.toString(), "", PageConstant.PAGE_PREFIX+PageConstant.PAGE_SEPARATOR+PageConstant.SET_PAGE);
	  }
	
	@RequestMapping(value="manage", method={RequestMethod.GET,RequestMethod.POST})
	  public ModelAndView manage(@RequestParam ("subid") Integer subid) throws Exception
	  {
	   
		return commonModelAndView("", subid.toString(), PageConstant.PAGE_PREFIX+PageConstant.PAGE_SEPARATOR+
	    		PageConstant.SET_PAGE+PageConstant.PAGE_SEPARATOR+PageConstant.USERINFO_PAGE);
	  }
	
	/**
	 * 
	 * 日期：2017年7月24日
	 * 作者：hanshao
	 * 定时任务
	 */
	@RequestMapping(value="task", method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView task(@RequestParam ("subid") Integer subid) throws Exception
	{
		
		return commonModelAndView("", subid.toString(),PageConstant.PAGE_PREFIX+PageConstant.PAGE_SEPARATOR+
				PageConstant.SET_PAGE+PageConstant.PAGE_SEPARATOR+PageConstant.TASK_PAGE);
	}
	
	/**
	 * 
	 * 日期：2017年7月24日
	 * 作者：hanshao
	 * TODO
	 */
	@RequestMapping(value="analy", method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView analy(@RequestParam ("subid") Integer subid) throws Exception
	{
		return commonModelAndView("", subid.toString(), PageConstant.PAGE_PREFIX+PageConstant.PAGE_SEPARATOR+
				PageConstant.SET_PAGE+PageConstant.PAGE_SEPARATOR+PageConstant.ANALY_PAGE);
		
	}
	
	/**
	 * 
	 * 日期：2017年7月24日
	 * 作者：hanshao
	 * TODO
	 */
	@RequestMapping(value="crawler", method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView crawler(@RequestParam ("subid") Integer subid) throws Exception
	{
		return commonModelAndView("", subid.toString(), PageConstant.PAGE_PREFIX+PageConstant.PAGE_SEPARATOR+
				PageConstant.SET_PAGE+PageConstant.PAGE_SEPARATOR+PageConstant.CRAWLER_PAGE);
	}
	
	/**
	 * 
	 * 日期：2017年7月24日
	 * 作者：hanshao
	 * TODO
	 */
	@RequestMapping(value="data", method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView data(@RequestParam ("subid") Integer subid) throws Exception
	{
		
		return commonModelAndView("", subid.toString(), PageConstant.PAGE_PREFIX+PageConstant.PAGE_SEPARATOR+
				PageConstant.SET_PAGE+PageConstant.PAGE_SEPARATOR+PageConstant.DATA_PAGE);
	}
	
	
	private ModelAndView commonModelAndView(String id,String subid,String page) {
		ModelAndView modelAndView = new ModelAndView(page);
		List<Setting> setList = iSetting.getObjectList();
	    modelAndView.addObject("setList", setList);
	    modelAndView.addObject("subactive", subid);
	    modelAndView.addObject("active", id);
	    
		return modelAndView;
	}
}
