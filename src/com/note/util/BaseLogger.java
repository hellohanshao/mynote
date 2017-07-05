package com.note.util;


import org.apache.log4j.Logger;


public class BaseLogger {
	private Logger log;

	public Logger getLogger() {
		if (log == null) {
			log = Logger.getLogger(this.getClass());
		}
		return log;
	}

}
