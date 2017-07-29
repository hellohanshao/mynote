package com.note.util;

import java.security.DigestException;

import org.bouncycastle.jcajce.provider.digest.SM3;
import org.bouncycastle.util.encoders.Hex;

/**
 * 
 * 日期：2017年7月28日
 * 作者：hanshao
 * 创建sm3加密工具类
 */
public class SM3Util {

	
	
	private String passwd;
	
	private static SM3Util sm3Util;
	
	public static  String getStr2SM3(String passwd) throws DigestException {
		
		if (passwd==null) {
			throw new DigestException("加密字符串为空");
		}
		
		
		byte[] pd = new SM3.Digest().digest(passwd.getBytes());
		
		return Hex.toHexString(pd);
	}

	public static SM3Util getSM3UtilInstance( ){
		if(null==sm3Util){
			return new SM3Util();
		}
		return sm3Util;
	}
	
	
	public SM3Util(){
		super();
	}
	
	public SM3Util(String passwd) throws DigestException {
		super();
		this.passwd = getStr2SM3(passwd);
	}

	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
}
