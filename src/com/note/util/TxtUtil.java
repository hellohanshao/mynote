package com.note.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.note.exception.NoteException;

/**
 * 
 * @author HS
 * 2017年8月18日 下午3:35:39
 * 文本文件生成和读取
 */
public class TxtUtil {

	/**
	 * 
	 * 2017年8月18日 下午3:39:51 HS 
	 * 读取文件 原格式复制
	 */
	public static String readTxt(String filePath) throws Exception{
		 String encoding = "GBK";
		 File file = readTxt2File(filePath);
		 StringBuffer sb = new StringBuffer();
		 FileInputStream fileInputStream = new FileInputStream(file);
		 InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,encoding);
		 BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		 String s = bufferedReader.readLine();
		 while(s!=null){
			 sb.append(s+"\n");
			 s= bufferedReader.readLine();
		 }
		 fileInputStream.close();
		 inputStreamReader.close();
		 bufferedReader.close();
		return sb.toString();
	}
	
	public static File readTxt2File(String filePath) throws Exception{
		File file = new File(filePath);
		if(!file.isFile()){
			throw new NoteException(filePath+"不是一个文件");
		}
		if(!file.exists()){
			throw new FileNotFoundException(filePath+"文件没有找到");
		}
		
		return file;
	}
	
	
	/**
	 * 
	 * 2017年8月18日 下午3:39:27 HS 
	 * TODO输出文件
	 * @throws IOException 
	 * file 
	 */
	public static void writeTxtFromFile(File file ,String filePath) throws IOException{
		
		File file2 = new File(filePath);
		if(!file2.exists()){
			file2.createNewFile();
			file2.canWrite();
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		FileOutputStream fileOutputStream = new FileOutputStream(file2);
		byte[] b = new byte[1024];
		fileOutputStream.write(b);
		fileOutputStream.flush();
		fileOutputStream.close();
	}
	
	/**
	 * 
	 * 2017年8月18日 下午3:39:27 HS 
	 * TODO输出文件
	 * @throws IOException 
	 */
	public static void writeTxtFromString(String txt,String filePath) throws IOException{
		
		File file2 = new File(filePath);
		if(!file2.exists()){
			file2.createNewFile();
			file2.canWrite();
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
		bw.write(txt);
		bw.flush();
		bw.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		try {
			
			//文件拷贝
			Files.copy(Paths.get("d:\\abcdef.txt"),Paths.get("f:\\abcdef1.txt"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
