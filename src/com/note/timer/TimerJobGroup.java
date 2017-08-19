package com.note.timer;

import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

import com.note.model.Task;
import com.note.model.TaskGroup;
/**
 * 
 * @author HS
 * 2017年7月30日 下午3:26:37
 * 封装定时任务组
 */
public class TimerJobGroup {

	private static SchedulerFactory gSchedulerFactory = new StdSchedulerFactory();  
    private static String JOB_GROUP_NAME = "EXTJWEB_JOBGROUP_NAME";  
    private static String TRIGGER_GROUP_NAME = "EXTJWEB_TRIGGERGROUP_NAME"; 
	private static Logger _log = Logger.getLogger(TimerJobGroup.class);
    
    /**
     * 
     * 2017年8月13日 下午8:44:32 HS 
     * TODO根据任务组合触发器组添加任务
     * 用于新建任务计划以及后续重启后的写入工作
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })  
    public static void addJob(String jobName, String jobGroupName, 
            String triggerName, String triggerGroupName, Class jobClass, String cron) {  
        try {  
            Scheduler sched = gSchedulerFactory.getScheduler();  
            // 任务名，任务组，任务执行类
            if(jobGroupName==null || jobGroupName.equals("")){
            	jobGroupName=JOB_GROUP_NAME;
            	_log.info("默认任务组为["+jobGroupName+"]");
            }
            
            JobDetail jobDetail= JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();

            // 触发器  
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            // 触发器名,触发器组  
            if(triggerGroupName==null || triggerGroupName.equals("")){
            	triggerGroupName=TRIGGER_GROUP_NAME;
            	_log.info("默认触发器组为["+triggerGroupName+"]");
            }
            
            triggerBuilder.withIdentity(triggerName, triggerGroupName);
            triggerBuilder.startNow();
            // 触发器时间设定  
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
            // 创建Trigger对象
            CronTrigger trigger = (CronTrigger) triggerBuilder.build();

            // 调度容器设置JobDetail和Trigger
            sched.scheduleJob(jobDetail, trigger);  
            _log.info("\n添加任务["+jobName+"]>>>触发器"+triggerName+">>>任务组["+jobGroupName+"]。。。。。。。成功");

            // 启动  
            if (!sched.isShutdown()) {  
                sched.start();  
                _log.info("\n任务已启动》》》》》》》》》》");
            }  
        } catch (Exception e) {  
        	 _log.error("\n添加任务["+jobName+"]>>>触发器"+triggerName+">>>任务组["+jobGroupName+"]。。。。。。。失败");
            throw new RuntimeException(e);  
        }  
    }  
    
    
    /** 
     * @Description: 修改一个任务的触发时间(使用默认的任务组名，触发器名，触发器组名) 
     */  
    @SuppressWarnings("unchecked")  
    public static void modifyJobTime(String jobName, String time) {  
        try {  
            Scheduler sched = gSchedulerFactory.getScheduler();  
            CronTrigger trigger = (CronTrigger) sched.getTrigger(TriggerKey.triggerKey(jobName));  
            if (trigger == null) {  
                return;  
            }  
            String oldTime = trigger.getCronExpression();  
            if (!oldTime.equalsIgnoreCase(time)) {  
                JobDetail jobDetail = sched.getJobDetail(JobKey.jobKey(jobName));  
                Class objJobClass = jobDetail.getJobClass();  
                removeJob(jobName);  
//                addJob(jobName, objJobClass, time,TRIGGER_GROUP_NAME);  
            }  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
  
    /** 
     * @Description: 修改一个任务的触发时间 
     */  
    public static void modifyJobTime(String triggerName,  
            String triggerGroupName, String time) {  
        try {  
            Scheduler sched = gSchedulerFactory.getScheduler();  
            CronTrigger trigger = (CronTrigger) sched.getTrigger(TriggerKey.triggerKey(triggerName,triggerGroupName));  
            if (trigger == null) {  
                return;  
            }  
            String oldTime = trigger.getCronExpression();  
            if (!oldTime.equalsIgnoreCase(time)) {  
                CronTrigger ct = (CronTrigger) trigger;  
                // 修改时间  
                ((CronTriggerImpl) ct).setCronExpression(time);  
                // 重启触发器  
                sched.resumeTrigger(TriggerKey.triggerKey(triggerName,triggerGroupName));  
            }  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
    
    /**
     * 
     * 2017年8月17日 下午1:07:40 HS 
     * TODO修改任务
     */
    public static void modifyJobTime(String jobName, 
            String jobGroupName, String triggerName, String triggerGroupName, String cron) {  
        try {  
        	Scheduler sched = gSchedulerFactory.getScheduler();   
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
            CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerKey);  
            if (trigger == null) {  
                return;  
            }  

            String oldTime = trigger.getCronExpression();  
            if (!oldTime.equalsIgnoreCase(cron)) { 
                /** 方式一 ：调用 rescheduleJob 开始 */
                // 触发器  
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                // 触发器名,触发器组  
                triggerBuilder.withIdentity(triggerName, triggerGroupName);
                triggerBuilder.startNow();
                // 触发器时间设定  
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
                // 创建Trigger对象
                trigger = (CronTrigger) triggerBuilder.build();
                // 方式一 ：修改一个任务的触发时间
                sched.rescheduleJob(triggerKey, trigger);
                /** 方式一 ：调用 rescheduleJob 结束 */

                /** 方式二：先删除，然后在创建一个新的Job  */
                //JobDetail jobDetail = sched.getJobDetail(JobKey.jobKey(jobName, jobGroupName));  
                //Class<? extends Job> jobClass = jobDetail.getJobClass();  
                //removeJob(jobName, jobGroupName, triggerName, triggerGroupName);  
                //addJob(jobName, jobGroupName, triggerName, triggerGroupName, jobClass, cron); 
                /** 方式二 ：先删除，然后在创建一个新的Job */
            }  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  

  
    /** 
     * @Description: 停止任务
     */  
    public static void pauseJob(String jobName,String groupName) {  
        try {  
        	Scheduler sched = gSchedulerFactory.getScheduler();  
        	JobKey jobKey = JobKey.jobKey(jobName,groupName);
        	sched.pauseJob(jobKey);
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
    
    /** 
     * @Description: 移除一个任务(使用默认的任务组名，触发器名，触发器组名) 默认的
     */  
    public static void removeJob(String jobName) {  
    	try {  
    		Scheduler sched = gSchedulerFactory.getScheduler();  
    		sched.pauseTrigger(TriggerKey.triggerKey(jobName, TRIGGER_GROUP_NAME));// 停止触发器  
    		sched.unscheduleJob(TriggerKey.triggerKey(jobName, TRIGGER_GROUP_NAME));// 移除触发器  
    		sched.deleteJob(JobKey.jobKey(jobName, TRIGGER_GROUP_NAME));// 删除任务  
    	} catch (Exception e) {  
    		throw new RuntimeException(e);  
    	}  
    }  
  
    /** 
     * @Description: 移除一个任务 
     */  
    public static void removeJob(String jobName, String jobGroupName,  
            String triggerName, String triggerGroupName) {  
        try {  
        	Scheduler sched = gSchedulerFactory.getScheduler();  
    		sched.pauseTrigger(TriggerKey.triggerKey(jobName, triggerGroupName));// 停止触发器  
    		sched.unscheduleJob(TriggerKey.triggerKey(jobName, triggerGroupName));// 移除触发器  
    		sched.deleteJob(JobKey.jobKey(jobName, jobGroupName));// 删除任务  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
  
    /** 
     * @Description:启动所有定时任务 
     */  
    public static void startJobs() {  
        try {  
            Scheduler sched = gSchedulerFactory.getScheduler();  
            sched.start();  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
  
    /** 
     * @Description:关闭所有定时任务 
     */  
    public static void shutdownJobs() {  
        try {  
            Scheduler sched = gSchedulerFactory.getScheduler();  
            if (!sched.isShutdown()) {  
                sched.shutdown();  
            }  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
    /**
     * 
     * 2017年8月16日 下午4:45:15 HS 
     * 根据新建任务计划添加作业
     */
	
    public static void addTaskJob(Task task,String cron){
    	if(cron==null|| cron.trim().equals("")){
    		cron="0 0/2 * * * ?";
    		_log.info("默认任务时间格式为["+cron+"]");
    	}
    	addJob(task.getTaskname(), task.getGroupname(), task.getTaskname(), task.getGroupname(), TimerJob.class, cron);
    }
    
}
