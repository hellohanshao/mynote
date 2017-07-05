package com.note.exception;

public class NoteException extends Exception{

	/**
	  * 日期：2017年7月5日
	  * 作者：李小波
	  * TODO
	 */
	private static final long serialVersionUID = -862420518412335718L;
	
	
	public NoteException (String message){
		super(message);
	}
	

	public NoteException (Throwable throwable){
		super(throwable.getMessage(), throwable);
	}
	
	
	public NoteException (String message,Throwable throwable){
		super(message, throwable);
	}
}
