package com.note.test;

public class ClassTest {

	
	public static void main(String[] args) {
		Class<?> cla=null;
		cla = String.class;
		try {
			Object object = Class.forName(cla.getName());
//			System.out.println(cla.getcon);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(cla);
	}
}
