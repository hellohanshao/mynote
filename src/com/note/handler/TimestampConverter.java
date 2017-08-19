package com.note.handler;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;

public class TimestampConverter implements Converter<String,Timestamp> {

	private Logger log = Logger.getLogger(TimestampConverter.class);
	@Override
	public Timestamp convert(String timestamp) {
				if(StringUtils.isNotEmpty(timestamp.trim())){
					
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					try {
						return  (Timestamp) simpleDateFormat.parse(timestamp);
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
