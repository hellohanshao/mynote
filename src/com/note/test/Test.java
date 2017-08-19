package com.note.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Test {

	
	public static void main(String[] args) {
		String s ="2017-02-02";
		SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINESE);
		Date parse;
		try {
			parse = ss.parse(s);
			
			System.out.println(ss.parse(ss.format(parse)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
