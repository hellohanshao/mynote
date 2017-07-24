package com.note.util;

import java.util.LinkedList;
import java.util.List;

public class CommonUtil {

	
	public static boolean isNull(String str){
		if (str==null) {
			return true;
		}
		if (str.equals("")) {
			return true;
		}
		
		return false;
	}
	
}
