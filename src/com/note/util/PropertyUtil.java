package com.note.util;

import java.io.*;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyUtil {

	
	 private static final Logger logger = LoggerFactory.getLogger(PropertyUtil.class);
	    private static Properties props;
	    static{
	        loadProps();
	    }
	    synchronized static private void loadProps(){
	        logger.info("开始加载constant.properties文件内容.......");
	        props = new Properties();
	        InputStream in = null;
	        try {
	            in = PropertyUtil.class.getResourceAsStream("/constant.properties");
	            props.load(in);
	        } catch (FileNotFoundException e) {
	            logger.error("constant.properties文件未找到");
	        } catch (IOException e) {
	            logger.error("IOException");
	        } finally {
	            try {
	                if(null != in) {
	                    in.close();
	                }
	            } catch (IOException e) {
	                logger.error("constant.properties文件流关闭出现异常");
	            }
	        }
	        logger.info("加载constant.properties文件内容完成...........");
	    }

	    public static String getProperty(String key){
	        if(null == props) {
	            loadProps();
	        }
	        return props.getProperty(key);
	    }

	    public static String getProperty(String key, String defaultValue) {
	        if(null == props) {
	            loadProps();
	        }
	        return props.getProperty(key, defaultValue);
	    }
	    
}
