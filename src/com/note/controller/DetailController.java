package com.note.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
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
@Controller
public class DetailController {

	@Autowired
	private IDeatil IDeatil;
	
	@Resource
	public JdbcTemplate jdbcTemplate;
	
	/*@RequestMapping(value="openDetail",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView detail2(@RequestParam ("id") String id) throws Exception{
		
		 ModelAndView modelAndView = new ModelAndView("jsp/saveDetail");
		 modelAndView.addObject("relation",id);
		return modelAndView;
	}*/
	
	//@RequestParam (value="detail")String detail,@RequestParam (value="detailname")String detailname
	@RequestMapping(value="insertDetail",method={RequestMethod.POST})
	@ResponseBody
	public JSON insertDetail(Detail detail2) {
		try {
			if (detail2!=null && !detail2.getDetailname().equals("")) {
				IDeatil.insertDetailOne(detail2);
				String sql = " select max(id) from detail ";
				 Map<String, Object> maxid = jdbcTemplate.queryForMap(sql);
				 
				return (JSON) JSON.parse("{status:1,id:"+maxid.get("MAX(ID)")+"}");
			}
		} catch (Exception e) {
			return (JSON) JSON.parse("{status:0}");
		}
		return (JSON) JSON.parse("{status:0}");
		
	}
	
	@RequestMapping(value="updateDetail",method={RequestMethod.POST})
	@ResponseBody
	public JSON updateDetail(Detail detail2) {
		try {
			if (detail2!=null && !detail2.getDetailname().equals("") && detail2.getId()!=0) {
				IDeatil.updateDetailOne(detail2.getId(), detail2);
				return (JSON) JSON.parse("{status:1}");
			}
		} catch (Exception e) {
			return (JSON) JSON.parse("{status:0}");
		}
		return (JSON) JSON.parse("{status:0}");
		
	}
	

	@RequestMapping(value="deleteDetail",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public JSON deleteSubtitle(Detail detail){
		try {
			if (detail!=null && detail.getId()!=0) {
				IDeatil.deleteDetailOne(detail.getId());
				return (JSON) JSON.parse("{status:1}");
			}
		} catch (Exception e) {
			return (JSON) JSON.parse("{status:0}");
		}
		return (JSON) JSON.parse("{status:0}");
	}
	
}
