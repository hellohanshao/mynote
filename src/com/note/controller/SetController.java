package com.note.controller;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.note.constant.PageConstant;
import com.note.crawler.CrawlerPageProcess;
import com.note.exception.NoteException;
import com.note.model.Setting;
import com.note.timer.TimerJob;
import com.note.model.Task;
import com.note.model.TaskGroup;
import com.note.service.IData;
import com.note.service.ISetting;
import com.note.service.ITask;
import com.note.service.ITaskGroup;
import com.note.service.ITitle;
import com.note.service.impl.TaskGroupImpl;
import com.note.timer.TimerJobGroup;
import com.note.util.CommonUtil;
/**
 * 
 * 日期：2017年7月1日
 * 作者：李小波
 * 用于主页标题、列表，详细列表展示
 */
@RequestMapping(PageConstant.SET_PAGE)
@Controller
public class SetController extends BaseController{
	
	Logger log = Logger.getLogger(SetController.class);
	
	@Autowired
	private ITitle ititle;
	
	@Autowired
	private ISetting iSetting;
	
	@Autowired
	private ITask itask;
	
	@Autowired
	private ITaskGroup itaskGroup;
	
	@Autowired
	private IData idata;
	
	
	
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
	public ModelAndView task(Task task) throws Exception
	{
		
		
		return commonModelAndView("", "",PageConstant.PAGE_PREFIX+PageConstant.PAGE_SEPARATOR+
				PageConstant.SET_PAGE+PageConstant.PAGE_SEPARATOR+PageConstant.TASK_PAGE);
	}
	/**
	 * 
	 * @param task
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping(value="taskAdd", method={RequestMethod.POST})
	public ModelAndView taskAdd(Task task)
	{
		if(!CommonUtil.isNull(task)){
			try {
				itask.addTask(task);
				if(task.getImmediately().equals("0")){
					TimerJobGroup.addTaskJob(task,"");
				}
			} catch (Exception e) {
				String str =new StringBuilder().append(e.getMessage()).toString();
				log.error(str);
			}
		}
		
		
		return commonModelAndView("", "",PageConstant.PAGE_PREFIX+PageConstant.PAGE_SEPARATOR+
				PageConstant.SET_PAGE+PageConstant.PAGE_SEPARATOR+PageConstant.TASK_PAGE);
	}
	
	/**
	 * 
	 * 2017年8月16日 上午9:07:28 HS 
	 * 添加任务组
	 */
	@RequestMapping(value="addTaskGroup", method={RequestMethod.POST})
	public ModelAndView addTaskGroup(TaskGroup taskGroup)
	{
		String msg = "";
		if(!CommonUtil.isNull(taskGroup)){
			try {
				itaskGroup.addTaskGroup(taskGroup);
				msg="添加成功";
			} catch (Exception e) {
				msg =new StringBuilder().append(e.getMessage()).toString();
				log.error(msg);
			}
		}
		ModelAndView model = new ModelAndView(PageConstant.PAGE_PREFIX+PageConstant.PAGE_SEPARATOR+
				PageConstant.SET_PAGE+PageConstant.PAGE_SEPARATOR+PageConstant.ADD_TASK_PAGE);
		model.addObject("msg", msg);
		
		return model;
	}
	/**
	 * 
	 * 2017年8月16日 上午9:07:28 HS 
	 * 添加任务组
	 */
	@RequestMapping(value="showTaskGroup", method={RequestMethod.GET})
	public ModelAndView showTaskGroup()
	{
		ModelAndView page = new ModelAndView(PageConstant.PAGE_PREFIX+PageConstant.PAGE_SEPARATOR+
				PageConstant.SET_PAGE+PageConstant.PAGE_SEPARATOR+PageConstant.ADD_TASK_PAGE);
		page.addObject("groupname", new TaskGroupImpl().getTaskGroup());
		
		return page;
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
	 * 正在执行的任务
	 */
	@RequestMapping(value="tasking", method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView tasking() throws Exception
	{
		return commonModelAndView("", "", PageConstant.PAGE_PREFIX+PageConstant.PAGE_SEPARATOR+
				PageConstant.SET_PAGE+PageConstant.PAGE_SEPARATOR+PageConstant.TASKING_PAGE);
		
	}
	/**
	 * 
	 * 日期：2017年7月24日
	 * 作者：hanshao
	 * 任务组明细
	 */
	@RequestMapping(value="taskgroup", method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView taskGroup(TaskGroup taskgroup) throws Exception
	{
		ModelAndView page = new ModelAndView( PageConstant.PAGE_PREFIX+PageConstant.PAGE_SEPARATOR+
				PageConstant.SET_PAGE+PageConstant.PAGE_SEPARATOR+PageConstant.TASKGROUP_PAGE);
		List<TaskGroup> list= new ArrayList<TaskGroup>();
		if(CommonUtil.isNull(taskgroup.getGroupname())){
			list = itaskGroup.getTaskGroupAll();
		}else{
			list.add(itaskGroup.getTaskGroup(taskgroup));
		}
		page.addObject("taskgroup", list);
		
		/*TimerJob timerJob  = new TimerJob();
		TimerJobGroup.addJob(1+"", null, "2", null, timerJob.getClass(), "0 0/2 * * * ?");*/
		return page;
	}
	/**
	 * 
	 * 日期：2017年7月24日
	 * 作者：hanshao
	 * 任务计划
	 */
	@RequestMapping(value="taskplan", method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView taskPlan(@RequestParam ("subid") Integer subid) throws Exception
	{
		return commonModelAndView("", subid.toString(), PageConstant.PAGE_PREFIX+PageConstant.PAGE_SEPARATOR+
				PageConstant.SET_PAGE+PageConstant.PAGE_SEPARATOR+PageConstant.TASKPLAN_PAGE);
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
		try {
			List<Setting> setList = iSetting.getObjectList();
			List<TaskGroup> groupname= itaskGroup.getTaskGroupAll();
			modelAndView.addObject("setList", setList);
			modelAndView.addObject("groupname", groupname);
			modelAndView.addObject("subactive", subid);
			modelAndView.addObject("active", id);
		} catch (NoteException e) {
			e.printStackTrace();
		}
	    
		return modelAndView;
	}
}
