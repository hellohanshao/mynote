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
import com.note.model.Detail;
import com.note.model.SubTitle;
import com.note.model.Title;
import com.note.service.IDeatil;
import com.note.service.ISubTitle;
import com.note.service.ITitle;
import com.sun.tools.corba.se.idl.StringGen;
/**
 * 
 * 日期：2017年7月1日
 * 作者：李小波
 * 用于主页标题、列表，详细列表展示
 */
@Controller
@RequestMapping("index")
public class IndexController {
	
	
	
	
	@Autowired
	private ITitle ititle;
	@Autowired
	private IDeatil ideatil;
	@Autowired
	private ISubTitle isubtitle;
	
	
	//此id为 子title的id
	@RequestMapping(value="subtitle", method={RequestMethod.GET,RequestMethod.POST})
	  public ModelAndView subtitle(@RequestParam ("subid") String subid,@RequestParam ("id") String id) throws Exception
	  {
		
		if(StringUtils.isBlank(subid.trim()) || StringUtils.isBlank(id.trim())){
			throw new Exception("找不到资源");
		}
		
		
	    List<SubTitle> subTitleList = this.isubtitle.getSubTitleByMasterID(Integer.valueOf(id));
	    
	    List<Title> titleList = this.ititle.getTitleList();
	    
	    List<Detail> detailList = ideatil.getDetailByMasterID(Integer.valueOf(subid));
	    
	    ModelAndView modelAndView = new ModelAndView("jsp/index");
	    modelAndView.addObject("titleList", titleList);
	    modelAndView.addObject("subTitleList", subTitleList);
	    modelAndView.addObject("detailList", detailList);
	    modelAndView.addObject("subactive", subid);
	    modelAndView.addObject("active", id);
	    return modelAndView;
	  }
	
	/**
	 * 
	 * 日期：2017年6月30日
	 * 作者：李小波
	 * TODO id为subtitle主键
	 * @throws Exception 
	 */
	@RequestMapping(value="detail2",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ModelAndView detail2(@RequestParam ("subid") String subid,@RequestParam ("id") String id,@RequestParam ("detailid") String detailid) throws Exception{
		 
		 ModelAndView modelAndView = new ModelAndView("jsp/index");
		 List<Title> titleList = ititle.getTitleList();
		 
		 if(StringUtils.isBlank(subid.trim()) || StringUtils.isBlank(id.trim()) || StringUtils.isBlank(detailid.trim())){
				throw new Exception("找不到资源");
			}
			
		 int subfixid=Integer.valueOf(subid);
		 int titleid=Integer.valueOf(id);
		 
		 Detail detail = ideatil.getDetail(Integer.valueOf(detailid));
		 List<Detail> detailsList = ideatil.getDetailByMasterID(subfixid);
		List<SubTitle> subTitleList = this.isubtitle.getSubTitleByMasterID(titleid);
		
		modelAndView.addObject("detail", detail);
		modelAndView.addObject("detailsList", detailsList);
		modelAndView.addObject("subTitleList", subTitleList);
		modelAndView.addObject("titleList", titleList);
		modelAndView.addObject("subactive", subid);
		modelAndView.addObject("active", id);
		modelAndView.addObject("detailactive", detailid);
		return modelAndView;
	}
	
	
	@RequestMapping(value="detail",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public JSON detail(@RequestParam ("subid") String subid,@RequestParam ("id") String id,@RequestParam ("detailid") String detailid) throws Exception{
		 
		 if(StringUtils.isBlank(subid.trim()) || StringUtils.isBlank(id.trim()) || StringUtils.isBlank(detailid.trim())){
				throw new Exception("找不到资源");
			}
		 
		Detail detail = ideatil.getDetail(Integer.valueOf(detailid));
		Object json = JSON.toJSON(detail);
		return (JSON) json;
	}
	
	/**
	 * 
	 * 日期：2017年6月30日
	 * 作者：李小波
	 * id为title主键
	 */
	@RequestMapping(value="",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index(@RequestParam ("id") String id){
		ModelAndView modelAndView = new ModelAndView("jsp/index");
		int fixid=0;
		List<Title> titleList = ititle.getTitleList();
		if (StringUtils.isBlank(id.trim())) {
			for (Title title : titleList) {
				if (title.getIsdefaultload()!=null) {
					int isdefault = Integer.valueOf(title.getIsdefaultload().trim());
					if (isdefault==1) {
						fixid=title.getId();
						break;
					}
				}
			}
		}else {
			fixid=Integer.valueOf(id.trim());
		}
		
		List<SubTitle> subTitleList = this.isubtitle.getSubTitleByMasterID(fixid);
		modelAndView.addObject("subTitleList", subTitleList);
		modelAndView.addObject("titleList", titleList);
		modelAndView.addObject("active", fixid);
		return modelAndView;
	}
	
	@RequestMapping(value="login2",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login2(){
		ModelAndView modelAndView = new ModelAndView("jsp/login2");
		return modelAndView;
	}

	
	
	
}
