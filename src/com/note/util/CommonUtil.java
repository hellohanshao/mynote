package com.note.util;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class CommonUtil {

	
	public static boolean isNull(String str){
		if (str==null) {
			return true;
		}
		if (str.trim().equals("")) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isNull(Object obj){
		if (obj==null) {
			return true;
		}
		
		return false;
	}
	
	
	/** 
     * 下载图片到本地 
     * @param picUrl 图片Url 
     * @param localPath 本地保存图片地址 
     * @return 
     */  
    /*public String downloadPicForNews(String picUrl,String localPath){  
        String filePath = "";  
        String url = "";  
        try {    
            URL httpurl = new URL(picUrl);  
           HttpURLConnection urlcon = (HttpURLConnection) httpurl.openConnection();  
           urlcon.setReadTimeout(3000);  
           urlcon.setConnectTimeout(3000);  
           int state = urlcon.getResponseCode(); //图片状态  
           if(state == 200){  
               String fileName = getFileNameFromUrl(picUrl);    
               filePath = localPath + fileName;  
               File f = new File(filePath);    
               FileUtils.copyURLToFile(httpurl, f);   
               Function fun = new Function();  
               url = filePath.replace("/www/web/imgs", fun.getProValue("IMG_PATH"));  
           }  
        } catch (Exception e) {    
            return null;    
        }   
        return url;  
    }  */
}
