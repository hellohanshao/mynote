package com.note.handler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String,Date> {

	private Logger log = Logger.getLogger(DateConverter.class);
	@Override
	public Date convert(String date) {
				if(StringUtils.isNotEmpty(date.trim())){
					
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					try {
						return  simpleDateFormat.parse(date);
					} catch (ParseException e) {
						try {
							log.error("格式化化时间戳异常");
							throw new Exception("格式化化时间戳异常");
						} catch (Exception e1) {
						}
					}
				}
				return null;
	}

}
