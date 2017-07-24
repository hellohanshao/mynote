package com.note.util;

import com.note.mq.ProducerService;

/**
 * 
 * 日期：2017年7月6日
 * 作者：李小波
 * 用户操作日志
 */
public class OperatorLog {

	
	public static void operator(String str,ProducerService producerService){
		producerService.sendMessage(str);
	}
}
