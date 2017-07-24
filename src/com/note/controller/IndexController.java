package com.note.controller;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
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
import com.note.util.CommonUtil;
import com.note.util.PropertyUtil;
/**
 * 
 * 日期：2017年7月1日
 * 作者：李小波
 * 用于主页标题、列表，详细列表展示
 */
@Controller
@RequestMapping(PageConstant.NOTE_PAGE)
public class IndexController extends BaseController{
	
	@Autowired
	private ITitle ititle;
	@Autowired
	private IDeatil ideatil;
	@Autowired
	private ISubTitle isubtitle;
	
	@Resource
	public JdbcTemplate jdbcTemplate;
	
	/*@ModelAttribute
	private  void addPage(ModelAndView view) {
		view.setViewName("jsp/index");
	}
	*/
	
	//此id为 子title的id
	@RequestMapping(value="subtitle", method={RequestMethod.GET,RequestMethod.POST})
	  public ModelAndView subtitle(@RequestParam ("subid") String subid,@RequestParam ("id") String id) throws Exception
	  {
		
		return commonModelAndView("jsp/index", id, subid, "","");
	  }
	
	//此id为 子title的id
	@RequestMapping(value="page", method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView page(@RequestParam ("subid") String subid,@RequestParam ("id") String id,@RequestParam ("page") String page) throws Exception
	{
		
		return commonModelAndView("jsp/index", id, subid, "",page);
	}
	
	/**
	 * 
	 * 日期：2017年7月19日
	 * 作者：李小波
	 * 用于笔记页面显示通用方法
	 * 
	 */
	 protected ModelAndView commonModelAndView(String pageName,String id,String subid,String detailid,String page){
		 String defaultNUM  = PropertyUtil.getProperty("DEFAULT_NUM");	
		 ModelAndView modelAndView = new ModelAndView(pageName);
		 List<Detail> detailList=null;
		 String sql="";
		 if (!CommonUtil.isNull(subid)) {
			 
			 sql = " select count(*) from detail where detailstatus='1' and id="+subid;
		 }else {
			 sql = " select count(*) from detail where detailstatus='1' ";
		}
		 Map<String, Object> maxid = jdbcTemplate.queryForMap(sql);
		 BigDecimal count = ((BigDecimal) maxid.get("COUNT(*)"));
		 int sumPage;
		 if (count.intValue()%(Integer.valueOf(defaultNUM))!=0) {
			  sumPage = count.intValue()/(Integer.valueOf(defaultNUM))+1;
		}else{
			  sumPage = count.intValue()/(Integer.valueOf(defaultNUM));
		}
		 
		 if (CommonUtil.isNull(page)) {
			 page="1";
		 }
		 modelAndView.addObject("currPage", page);
		 modelAndView.addObject("sumPage", sumPage);
			
		//默认初始化加载那个标题
		 if (CommonUtil.isNull(id)) {
			 id = PropertyUtil.getProperty("DEFAULT_PAGE");
		}
		 //点击主菜单显示 只需要将主菜单 还有子菜单、详细内容列表显示出来
		 if (!CommonUtil.isNull(id)) {
			 List<Title> titleList = this.ititle.getTitleList();
			 List<SubTitle> subTitleList = this.isubtitle.getSubTitleByMasterID(Integer.valueOf(id));
			 detailList = ideatil.getDetailList(page,defaultNUM);
			 modelAndView.addObject("titleList", titleList);
			 modelAndView.addObject("subTitleList", subTitleList);
			 modelAndView.addObject("active", id);
		}
		 
		 	if (!CommonUtil.isNull(subid)) {
		 		 //默认页面显示条数page
		 		 detailList = ideatil.getDetailPage(Integer.valueOf(subid), page, defaultNUM);
		 		 modelAndView.addObject("subactive", subid);
			}
		 	//默认显示内容长度
		 	for (Detail d : detailList) {
		 		if (d.getDetail().length()>Integer.valueOf(PropertyUtil.getProperty("CONTENT_LENGTH"))) {
		 			d.setDetail(d.getDetail().substring(0, Integer.valueOf(PropertyUtil.getProperty("CONTENT_LENGTH"))));
				}
			}
		 	
		 	//点击详细菜单搜索
		 	if (!CommonUtil.isNull(detailid)) {
		 		
		 		Detail detail = ideatil.getDetail(Integer.valueOf(detailid));
		 		modelAndView.addObject("detail", detail);
		 		modelAndView.addObject("detailactive", detailid);
		 	}
		 	
		 	modelAndView.addObject("detailList", detailList);
		    return modelAndView;
	 }
	
	 
	/**
	 * 
	 * 日期：2017年6月30日
	 * 作者：李小波
	 * TODO id为subtitle主键
	 * @throws Exception 
	 */
	@RequestMapping(value="detail",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView detail(@RequestParam ("subid") String subid,@RequestParam ("id") String id,@RequestParam ("detailid") String detailid) throws Exception{
		return commonModelAndView("jsp/layEditor", id, subid, detailid,"");
	}
	
	
	@RequestMapping(value="detailJson",method={RequestMethod.GET,RequestMethod.POST})
	public JSON detailJson(@RequestParam ("subid") String subid,@RequestParam ("id") String id,@RequestParam ("detailid") String detailid) throws Exception{
		 
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
	 * subactive active 分别为子标题、主标题点击显示
	 * 
	 */
	@RequestMapping(value="",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index(@RequestParam ("id") String id){
		return commonModelAndView("jsp/index", id, "", "","");
	}
	
	@RequestMapping(value="login2",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login2(){
		ModelAndView modelAndView = new ModelAndView("jsp/login2");
		return modelAndView;
	}

	@RequestMapping(value="socket",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView socket(){
		ModelAndView modelAndView = new ModelAndView("jsp/socket");
		return modelAndView;
	}
	
	@RequestMapping(value="controller",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView controller(){
		ModelAndView modelAndView = new ModelAndView("jsp/controller");
		return modelAndView;
	}
	
	//新建笔记标题 一级菜单
	@RequestMapping(value="insertSubtitle",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public JSON insertSubtitle(SubTitle subTitle){
		try {
			if (subTitle!=null && !subTitle.getSubtitle().equals("")) {
				isubtitle.insertSubTitleOne(subTitle);
				return (JSON) JSON.parse("{status:1}");
			}
		} catch (Exception e) {
			return (JSON) JSON.parse("{status:0}");
		}
		return (JSON) JSON.parse("{status:0}");
	}

	//编辑菜单
	@RequestMapping(value="editorSubtitle",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public JSON editorSubtitle(SubTitle subTitle){
		try {
			if (subTitle!=null && !subTitle.getSubtitle().equals("")) {
				isubtitle.updateSubTitleOne(subTitle);
				return (JSON) JSON.parse("{status:1}");
			}
		} catch (Exception e) {
			
			return (JSON) JSON.parse("{status:0}");
		}
		return (JSON) JSON.parse("{status:0}");
	}
	
	@RequestMapping(value="newNote",method={RequestMethod.GET,RequestMethod.POST})
	public JSON newNote(SubTitle subTitle){
		try {
			if (subTitle!=null && !subTitle.getSubtitle().equals("")) {
				isubtitle.insertSubTitleOne(subTitle);
				return (JSON) JSON.parse("{status:1}");
			}
		} catch (Exception e) {
			return (JSON) JSON.parse("{status:0}");
		}
		return (JSON) JSON.parse("{status:0}");
	}
	
	@RequestMapping(value="newSubtitle",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public JSON newSubtitle(SubTitle subTitle){
		try {
			if (subTitle!=null && !subTitle.getSubtitle().equals("")) {
				isubtitle.insertSubTitleOne(subTitle);
				return (JSON) JSON.parse("{status:1}");
			}
		} catch (Exception e) {
			return (JSON) JSON.parse("{status:0}");
		}
		return (JSON) JSON.parse("{status:0}");
	}
	
	@RequestMapping(value="deleteSubtitle",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public JSON deleteSubtitle(SubTitle subTitle){
		try {
			if (subTitle!=null && subTitle.getId()!=0) {
				isubtitle.deleteSubTitleOne(subTitle.getId());
				return (JSON) JSON.parse("{status:1}");
			}
		} catch (Exception e) {
			return (JSON) JSON.parse("{status:0}");
		}
		return (JSON) JSON.parse("{status:0}");
	}
	
	@Override
	protected ITitle getITitle() {
		return ititle;
	}
	
}
